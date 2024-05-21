package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.TipoVehiculoDTO;
import co.edu.usbcali.parqueaderoservice.models.TipoVehiculo;

import java.util.List;

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

    public static List<TipoVehiculoDTO> domainToDtoList (List<TipoVehiculo> tipoVehiculos){
        return tipoVehiculos.stream().map(TipoVehiculoMapper::domainToDto).toList();
    }

    public static List<TipoVehiculo> dtoToDomainList (List<TipoVehiculoDTO> tipoVehiculoDTOS){
        return tipoVehiculoDTOS.stream().map(TipoVehiculoMapper::dtoToDomain).toList();
    }
}
