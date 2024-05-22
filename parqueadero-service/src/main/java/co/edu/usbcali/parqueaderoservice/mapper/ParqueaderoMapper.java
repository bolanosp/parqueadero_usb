package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;

import java.util.List;

public class ParqueaderoMapper {

    public static ParqueaderoDTO domainToDto(Parqueadero parqueadero){

        ParqueaderoDTO parqueaderoDTO = ParqueaderoDTO
                .builder()
                .id(parqueadero.getId())
                .ubicacion(parqueadero.getUbicacion())
                .disponibilidad(parqueadero.getDisponibilidad())
                .vehiculo(parqueadero.getVehiculo() != null ? parqueadero.getVehiculo().getId() : null)
                .build();

        return parqueaderoDTO;
    }


    public static Parqueadero dtoToDomain(ParqueaderoDTO parqueaderoDTO) throws Exception{

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(parqueaderoDTO.getVehiculo());

        Parqueadero parqueadero = Parqueadero.builder()
                .id(parqueaderoDTO.getId())
                .ubicacion(parqueaderoDTO.getUbicacion())
                .disponibilidad(parqueaderoDTO.getDisponibilidad())
                .vehiculo(vehiculo)
                .build();

        return parqueadero;
    }

    public static List<ParqueaderoDTO> domainToDtoList(List<Parqueadero> parqueaderos){
        return parqueaderos.stream().map(ParqueaderoMapper::domainToDto).toList();
    }

}
