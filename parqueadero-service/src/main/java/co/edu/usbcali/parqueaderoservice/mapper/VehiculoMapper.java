package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.VehiculoDTO;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;

public class VehiculoMapper {
    public static VehiculoDTO domainToDto(Vehiculo vehiculo){
        return VehiculoDTO
                .builder()
                .id(vehiculo.getId())
                .placa(vehiculo.getPlaca())
                .build();
    }

    public static Vehiculo dtoToDomain(VehiculoDTO vehiculoDto){
        return Vehiculo
                .builder()
                .id(vehiculoDto.getId())
                .placa(vehiculoDto.getPlaca())
                .build();
    }
}
