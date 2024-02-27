package co.edu.usbcali.parqueaderoservice.dto;

import co.edu.usbcali.parqueaderoservice.models.Parqueadero;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private Integer id;
    private Date horaEntrada;
    private String estado;
    private Vehiculo vehiculo;
    private Parqueadero parqueadero;
}

