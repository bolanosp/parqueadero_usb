package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;

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

    public static Parqueadero domainToDto(ParqueaderoDTO parqueaderoDTO){
        return Parqueadero
                .builder()
                .id(parqueaderoDTO.getId())
                .ubicacion(parqueaderoDTO.getUbicacion())
                .disponibilidad(parqueaderoDTO.getDisponibilidad())
                .build();
    }
}
