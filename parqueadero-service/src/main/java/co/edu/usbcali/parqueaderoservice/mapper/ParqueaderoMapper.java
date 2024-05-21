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
                .build();

        // Verificar si el vehículo no es nulo antes de asignar su ID al DTO
        if (parqueadero.getVehiculo() != null) {
            parqueaderoDTO.setVehiculo(parqueadero.getVehiculo().getId());
        }

        return parqueaderoDTO;
    }


    public static Parqueadero dtoToDomain(ParqueaderoDTO parqueaderoDTO) throws Exception{

        // Crear una instancia de Parqueadero
        Parqueadero parqueadero = Parqueadero.builder()
                .id(parqueaderoDTO.getId())
                .ubicacion(parqueaderoDTO.getUbicacion())
                .disponibilidad(parqueaderoDTO.getDisponibilidad())
                .build();

        // Solo asignar vehículo si la disponibilidad es false
        if (parqueaderoDTO.getDisponibilidad() == Boolean.FALSE) {
            if (parqueaderoDTO.getVehiculo() == null) {
                throw new Exception("Debe proporcionar un vehículo cuando no hay disponibilidad");
            }

            // Crear una instancia de vehículo y asignarlo al parqueadero
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setId(parqueaderoDTO.getVehiculo());
            parqueadero.setVehiculo(vehiculo);
        }

        return parqueadero;
    }

    public static List<ParqueaderoDTO> domainToDtoList(List<Parqueadero> parqueaderos){
        return parqueaderos.stream().map(ParqueaderoMapper::domainToDto).toList();
    }

    public static List<Parqueadero> dtoToDomainList(List<ParqueaderoDTO> parqueaderoDto) {
        return parqueaderoDto.stream()
                .map(parqueaderoDTO -> {
                    try {
                        return ParqueaderoMapper.dtoToDomain(parqueaderoDTO);
                    } catch (Exception e) {
                        return null;
                    }
                })
                .toList();
    }
}
