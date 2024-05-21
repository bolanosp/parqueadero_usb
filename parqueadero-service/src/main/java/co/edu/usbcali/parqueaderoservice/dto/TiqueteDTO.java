package co.edu.usbcali.parqueaderoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TiqueteDTO {
    private Integer id;
    private Date horaEntrada;
    private Date horaSalida;
    private Double descuento;
    private Double valor;
    private Integer vehiculo;
    private Integer parqueadero;
}
