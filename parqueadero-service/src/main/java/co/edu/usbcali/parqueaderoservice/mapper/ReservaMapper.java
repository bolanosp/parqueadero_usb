package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.dto.ReservaDTO;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;
import co.edu.usbcali.parqueaderoservice.models.Reserva;

import java.util.List;

public class ReservaMapper {
    public static ReservaDTO domainToDto(Reserva reserva){
        return ReservaDTO
                .builder()
                .id(reserva.getId())
                .horaEntrada(reserva.getHoraEntrada())
                .estado(reserva.getEstado())
                .vehiculo((reserva != null) ? reserva.getVehiculo().getId()
                        : null)
                .parqueadero((reserva != null) ? reserva.getParqueadero().getId()
                        : null)
                .build();
    }

    public static Reserva dtoToDomain(ReservaDTO reservaDTO){
        return Reserva
                .builder()
                .id(reservaDTO.getId())
                .horaEntrada(reservaDTO.getHoraEntrada())
                .estado(reservaDTO.getEstado())
                .build();
    }

    public static List<ReservaDTO> domainToDtoList(List<Reserva> reservas){
        return reservas.stream().map(ReservaMapper::domainToDto).toList();
    }

    public static List <Reserva> dtoToDomainList(List<ReservaDTO> reservasDto){
        return  reservasDto.stream().map(ReservaMapper::dtoToDomain).toList();
    }

}
