package co.edu.usbcali.parqueaderoservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parqueadero")
public class Parqueadero {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "ubicacion")
    private String ubicacion;

    @Column(nullable = false, name = "disponibilidad")
    private Boolean disponibilidad;

    @OneToOne
    @JoinColumn(nullable = true, name = "id_vehiculo", referencedColumnName = "id")
    private Vehiculo vehiculo;

    @PrePersist
    @PreUpdate
    private void validate() {
        if (disponibilidad == Boolean.FALSE && vehiculo == null) {
            throw new IllegalArgumentException("Parqueadero no disponible debe tener un vehículo asignado");
        }
        if (disponibilidad == Boolean.TRUE && vehiculo != null) {
            throw new IllegalArgumentException("Parqueadero disponible no debe tener un vehículo asignado");
        }
    }
}
