package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.TiqueteDTO;
import co.edu.usbcali.parqueaderoservice.models.Tiquete;

public class TiqueteMapper {
    public static Tiquete tdoToDomain(TiqueteDTO tiqueteDTO){
        Tiquete tiquete = new Tiquete();
        tiquete.setId(tiqueteDTO.getId());
        tiquete.setHoraEntrada(tiqueteDTO.getHoraEntrada());
        tiquete.setHoraSalida(tiqueteDTO.getHoraSalida());
        tiquete.setDescuento(tiquete.getDescuento());
        tiquete.setValor(tiqueteDTO.getValor());
        tiquete.setVehiculo(tiqueteDTO.getVehiculo());
        return null;
    }
}
