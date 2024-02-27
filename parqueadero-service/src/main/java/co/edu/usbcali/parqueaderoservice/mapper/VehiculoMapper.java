package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.VehiculoDTO;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;

public class VehiculoMapper {
    public static Vehiculo dtoToDomain(VehiculoDTO vehiculoDTO){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(vehiculoDTO.getId());
        vehiculo.setPlaca(vehiculoDTO.getPlaca());
        vehiculo.setTipoVehiculo(vehiculoDTO.getTipoVehiculo());
        vehiculo.setUsuario(vehiculoDTO.getUsuario());
        return null;
    }

    public  static  VehiculoDTO domainToDto(Vehiculo vehiculo){
        return null;
    }
}
