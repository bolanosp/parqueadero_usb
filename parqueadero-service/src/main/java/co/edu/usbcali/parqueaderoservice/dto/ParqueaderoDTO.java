package co.edu.usbcali.parqueaderoservice.dto;

import co.edu.usbcali.parqueaderoservice.models.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParqueaderoDTO {
    private Integer id;
    private String ubicacion;
    private Boolean disponibilidad;
    private Vehiculo vehiculo;
}
}
