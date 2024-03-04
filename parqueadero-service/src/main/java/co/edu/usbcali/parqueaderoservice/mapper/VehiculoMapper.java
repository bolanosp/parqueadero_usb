package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.VehiculoDTO;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;

public class VehiculoMapper {
    public static VehiculoDTO domainToDto(Vehiculo vehiculo){
        return VehiculoDTO
                .builder()
                .id(vehiculo.getId())
                .placa(vehiculo.getPlaca())
                .tipoVehiculo((vehiculo != null) ? vehiculo.getTipoVehiculo().getId()
                        : null)
                .usuario((vehiculo != null) ? vehiculo.getUsuario().getId()
                        : null)
                .build();
    }

    public static Vehiculo dtoToDomain(VehiculoDTO vehiculoDTO){
        return Vehiculo
                .builder()
                .id(vehiculoDTO.getId())
                .placa(vehiculoDTO.getPlaca())
                .build();
    }
}
