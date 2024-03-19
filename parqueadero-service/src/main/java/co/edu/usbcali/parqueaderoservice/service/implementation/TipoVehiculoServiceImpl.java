package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.repository.TipoVehiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoVehiculoServiceImpl {

    private final TipoVehiculoRepository tipoVehiculoRepository;

    public TipoVehiculoServiceImpl(TipoVehiculoRepository tipoVehiculoRepository) {
        this.tipoVehiculoRepository = tipoVehiculoRepository;
    }
}
