package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.ReservaDTO;
import co.edu.usbcali.parqueaderoservice.models.Reserva;

public class ReservaMapper {

    public static Reserva dtoToDomain(ReservaDTO reservaDTO){
        Reserva reserva = new Reserva();
        reserva.setId(reservaDTO.getId());
        reserva.setHoraEntrada(reservaDTO.getHoraEntrada());
        reserva.setEstado(reservaDTO.getEstado());
        reserva.setVehiculo(reservaDTO.getVehiculo());
        reserva.setParqueadero(reservaDTO.getParqueadero());
        return null;
    }
}
