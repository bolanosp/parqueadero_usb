package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.TipoVehiculoDTO;
import co.edu.usbcali.parqueaderoservice.models.TipoVehiculo;

public class TipoVehiculoMapper {
    public static TipoVehiculo dtoToDomain(TipoVehiculoDTO tipoVehiculoDTO){
        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        tipoVehiculo.setId(tipoVehiculoDTO.getId());
        tipoVehiculo.setNombre(tipoVehiculoDTO.getNombre());
        tipoVehiculo.setTarifa(tipoVehiculoDTO.getTarifa());
        return null;
    }

    public static TipoVehiculoDTO domainToDto(TipoVehiculo tipoVehiculo){
        return null;
    }
}
