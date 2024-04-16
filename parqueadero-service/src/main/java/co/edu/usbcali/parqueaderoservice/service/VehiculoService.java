package co.edu.usbcali.parqueaderoservice.service;

import co.edu.usbcali.parqueaderoservice.dto.FacturaDTO;
import co.edu.usbcali.parqueaderoservice.dto.VehiculoDTO;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;

public interface VehiculoService {

    VehiculoDTO crearNuevoVehiculo (VehiculoDTO vehiculoDTO) throws Exception;

    Vehiculo buscarVehiculoPorId(Integer id) throws Exception;
}
