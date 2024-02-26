package co.edu.usbcali.parqueaderoservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date horaEntrada;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idVehiculo", referencedColumnName = "id", nullable = false)
    private Vehiculo vehiculo;

    @OneToOne
    @JoinColumn(name = "idParqueadero", referencedColumnName = "id", nullable = false)
    private Parqueadero parqueadero;
}
