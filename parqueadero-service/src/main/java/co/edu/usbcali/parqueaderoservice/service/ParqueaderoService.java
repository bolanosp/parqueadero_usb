package co.edu.usbcali.parqueaderoservice.service;

import java.util.List;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;

public interface ParqueaderoService {

    List<ParqueaderoDTO> obtenerParqueaderos () throws Exception;

    ParqueaderoDTO ingresarVehiculo (Integer idParqueadero, Integer idVehiculo) throws Exception;

    ParqueaderoDTO retirarVehiculo (Integer idParqueadero) throws  Exception;

}
