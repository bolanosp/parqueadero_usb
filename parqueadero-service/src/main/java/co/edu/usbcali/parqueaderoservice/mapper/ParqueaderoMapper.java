package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;

import java.util.List;

public class ParqueaderoMapper {
    public static ParqueaderoDTO domainToDto(Parqueadero parqueadero){
        return ParqueaderoDTO
                .builder()
                .id(parqueadero.getId())
                .ubicacion(parqueadero.getUbicacion())
                .disponibilidad(parqueadero.getDisponibilidad())
                .vehiculo((parqueadero != null) ? parqueadero.getVehiculo().getId()
                        : null)
                .build();
    }

    public static Parqueadero dtoToDomain(ParqueaderoDTO parqueaderoDTO){
        return Parqueadero
                .builder()
                .id(parqueaderoDTO.getId())
                .ubicacion(parqueaderoDTO.getUbicacion())
                .disponibilidad(parqueaderoDTO.getDisponibilidad())
                .build();
    }

    public static List<ParqueaderoDTO> domainToDtoList(List<Parqueadero> parqueaderos){
        return parqueaderos.stream().map(ParqueaderoMapper::domainToDto).toList();
    }

    public static List <Parqueadero> dtoToDomainList(List<ParqueaderoDTO> parqueaderoDto){
        return  parqueaderoDto.stream().map(ParqueaderoMapper::dtoToDomain).toList();
    }
}
