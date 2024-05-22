package co.edu.usbcali.parqueaderoservice.service;

import co.edu.usbcali.parqueaderoservice.dto.TiqueteDTO;

public interface TiqueteService {

    TiqueteDTO ingresarVehiculo (Integer idParqueadero, Integer idVehiculo) throws Exception;

    TiqueteDTO retirarVehiculo (Integer idTiquete) throws Exception;
}
