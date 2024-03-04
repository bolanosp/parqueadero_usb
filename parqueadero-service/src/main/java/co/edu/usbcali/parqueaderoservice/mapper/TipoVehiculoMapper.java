package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.TipoVehiculoDTO;
import co.edu.usbcali.parqueaderoservice.models.TipoVehiculo;

public class TipoVehiculoMapper {
    public static TipoVehiculoDTO domainToDto(TipoVehiculo tipoVehiculo){
        return TipoVehiculoDTO
                .builder()
                .id(tipoVehiculo.getId())
                .nombre(tipoVehiculo.getNombre())
                .tarifa(tipoVehiculo.getTarifa())
                .build();
    }

    public static TipoVehiculo dtoToDomain(TipoVehiculoDTO tipoVehiculoDTO){
        return TipoVehiculo
                .builder()
                .id(tipoVehiculoDTO.getId())
                .nombre(tipoVehiculoDTO.getNombre())
                .tarifa(tipoVehiculoDTO.getTarifa())
                .build();
    }
}
