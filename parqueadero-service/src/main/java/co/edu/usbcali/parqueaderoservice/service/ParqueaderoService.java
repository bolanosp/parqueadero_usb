package co.edu.usbcali.parqueaderoservice.service;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;

public interface ParqueaderoService {

    ParqueaderoDTO crearNuevoParqueadero (ParqueaderoDTO parqueaderoDTO) throws Exception;
    boolean existeVehiculo(Integer idVehiculo) throws Exception;

    ParqueaderoDTO buscarPorId(Integer id) throws Exception;

}
