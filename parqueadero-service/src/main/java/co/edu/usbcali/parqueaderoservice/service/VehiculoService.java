package co.edu.usbcali.parqueaderoservice.service;

import co.edu.usbcali.parqueaderoservice.dto.FacturaDTO;
import co.edu.usbcali.parqueaderoservice.dto.VehiculoDTO;

public interface VehiculoService {

    VehiculoDTO crearNuevoVehiculo (VehiculoDTO vehiculoDTO) throws Exception;
}
