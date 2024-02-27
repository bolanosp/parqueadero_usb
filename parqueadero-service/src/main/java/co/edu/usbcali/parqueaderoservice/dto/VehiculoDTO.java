package co.edu.usbcali.parqueaderoservice.dto;

import co.edu.usbcali.parqueaderoservice.models.TipoVehiculo;
import co.edu.usbcali.parqueaderoservice.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
    private Integer id;
    private String placa;
    private TipoVehiculo tipoVehiculo;
    private Usuario usuario;
}
