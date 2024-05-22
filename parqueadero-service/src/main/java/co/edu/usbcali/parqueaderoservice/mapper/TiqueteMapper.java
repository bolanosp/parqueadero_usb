package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.TiqueteDTO;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;
import co.edu.usbcali.parqueaderoservice.models.Tiquete;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;

import java.util.List;

public class TiqueteMapper {
    public static TiqueteDTO domainToDto(Tiquete tiquete){
        return TiqueteDTO
                .builder()
                .id(tiquete.getId())
                .horaEntrada(tiquete.getHoraEntrada())
                .horaSalida(tiquete.getHoraSalida())
                .descuento(tiquete.getDescuento())
                .valor(tiquete.getValor())
                .vehiculo(tiquete.getVehiculo() != null ? tiquete.getVehiculo().getId(): null)
                .parqueadero(tiquete.getParqueadero() != null ? tiquete.getParqueadero().getId(): null)
                .build();
    }

    public static Tiquete dtoToDomain(TiqueteDTO tiqueteDTO){

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(tiqueteDTO.getVehiculo());

        Parqueadero parqueadero = new Parqueadero();
        parqueadero.setId(tiqueteDTO.getParqueadero());

        return Tiquete
                .builder()
                .id(tiqueteDTO.getId())
                .horaEntrada(tiqueteDTO.getHoraEntrada())
                .horaSalida(tiqueteDTO.getHoraSalida())
                .descuento(tiqueteDTO.getDescuento())
                .valor(tiqueteDTO.getValor())
                .vehiculo(vehiculo)
                .parqueadero(parqueadero)
                .build();
    }

    public static List<TiqueteDTO> domainToDtoList (List<Tiquete> tiquetes){
        return tiquetes.stream().map(TiqueteMapper::domainToDto).toList();
    }

}
