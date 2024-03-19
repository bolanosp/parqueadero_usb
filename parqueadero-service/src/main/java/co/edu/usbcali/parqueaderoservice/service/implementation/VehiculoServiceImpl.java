package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class VehiculoServiceImpl {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }
}
