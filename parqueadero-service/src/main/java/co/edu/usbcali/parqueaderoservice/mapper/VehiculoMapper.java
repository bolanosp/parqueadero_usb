package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.VehiculoDTO;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;

import java.util.List;

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

    public static List<VehiculoDTO> domainToDtoList (List<Vehiculo> vehiculos){
        return vehiculos.stream().map(VehiculoMapper::domainToDto).toList();
    }

    public static List<Vehiculo> dtoToDomainList (List<VehiculoDTO> vehiculoDTOS){
        return vehiculoDTOS.stream().map(VehiculoMapper::dtoToDomain).toList();
    }
}
