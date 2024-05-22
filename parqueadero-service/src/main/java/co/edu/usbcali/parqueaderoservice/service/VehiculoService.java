package co.edu.usbcali.parqueaderoservice.service;

import java.util.List;

import co.edu.usbcali.parqueaderoservice.dto.VehiculoDTO;

public interface VehiculoService {

    VehiculoDTO crearNuevoVehiculo (VehiculoDTO vehiculoDTO) throws Exception;

    List<VehiculoDTO> obtenerVehiculos () throws Exception;

    VehiculoDTO obtenerVehiculoPorId(Integer id) throws Exception;
    
}
