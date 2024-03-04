package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.TiqueteDTO;
import co.edu.usbcali.parqueaderoservice.models.Tiquete;

public class TiqueteMapper {
    public static TiqueteDTO domainToDto(Tiquete tiquete){
        return TiqueteDTO
                .builder()
                .id(tiquete.getId())
                .horaEntrada(tiquete.getHoraEntrada())
                .horaSalida(tiquete.getHoraSalida())
                .descuento(tiquete.getDescuento())
                .valor(tiquete.getValor())
                .vehiculo((tiquete != null) ? tiquete.getVehiculo().getId()
                        : null)
                .build();
    }

    public static Tiquete dtoToDomain(TiqueteDTO tiqueteDTO){
        return Tiquete
                .builder()
                .id(tiqueteDTO.getId())
                .horaEntrada(tiqueteDTO.getHoraEntrada())
                .horaSalida(tiqueteDTO.getHoraSalida())
                .descuento(tiqueteDTO.getDescuento())
                .valor(tiqueteDTO.getValor())
                .build();
    }
}
