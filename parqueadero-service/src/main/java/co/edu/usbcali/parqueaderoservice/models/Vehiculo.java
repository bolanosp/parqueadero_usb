package co.edu.usbcali.parqueaderoservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "La placa es obligatoria")
    private String placa;

    @ManyToOne
    @JoinColumn(name = "id_tipo_vehiculo", referencedColumnName = "id", nullable = false)
    @NotBlank(message = "El tipo de vehiculo es obligatorio")
    private TipoVehiculo tipoVehiculo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    @NotBlank(message = "El usuario es obligatorio")
    private Usuario usuario;
}
