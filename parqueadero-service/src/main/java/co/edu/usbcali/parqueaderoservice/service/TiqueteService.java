package co.edu.usbcali.parqueaderoservice.service;

import co.edu.usbcali.parqueaderoservice.dto.TiqueteDTO;

public interface TiqueteService {

    TiqueteDTO crearNuevoTiquete (TiqueteDTO tiqueteDTO) throws Exception;
    TiqueteDTO darSalidaAVehiculo(Integer idTiquete, String horaSalida) throws Exception;
}
