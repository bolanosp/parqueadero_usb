package co.edu.usbcali.parqueaderoservice.service;

import java.util.List;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;

public interface ParqueaderoService {

    List<ParqueaderoDTO> obtenerParqueaderos () throws Exception;

    void ingresarVehiculo (Parqueadero parqueadero, Vehiculo vehiculo) throws Exception;

    void retirarVehiculo (Parqueadero parqueadero) throws  Exception;

}
