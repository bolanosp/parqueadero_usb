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
@Table(name = "tiquete")
public class Tiquete {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hora_entrada", nullable = false)
    private Date horaEntrada;

    @Column(name = "hora_salida")
    private Date horaSalida;

    @Column
    private Double descuento;

    @Column
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id", nullable = false)
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_parqueadero", referencedColumnName = "id", nullable = false)
    private Parqueadero parqueadero;
}
