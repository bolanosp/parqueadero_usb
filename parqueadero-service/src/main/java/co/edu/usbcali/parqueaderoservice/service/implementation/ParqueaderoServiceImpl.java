package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.mapper.ParqueaderoMapper;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;
import co.edu.usbcali.parqueaderoservice.repository.ParqueaderoRepository;
import co.edu.usbcali.parqueaderoservice.repository.VehiculoRepository;
import co.edu.usbcali.parqueaderoservice.service.ParqueaderoService;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ParqueaderoServiceImpl implements ParqueaderoService {

    private final ParqueaderoRepository parqueaderoRepository;
    public ParqueaderoServiceImpl(ParqueaderoRepository parqueaderoRepository, VehiculoRepository vehiculoRepository) {
        this.parqueaderoRepository = parqueaderoRepository;
    }

    @Override
    public List<ParqueaderoDTO> obtenerParqueaderos () throws Exception{
        List<Parqueadero> parqueaderos = parqueaderoRepository.findAll();
        return ParqueaderoMapper.domainToDtoList(parqueaderos);
    }

    @Override
    public void ingresarVehiculo (Parqueadero parqueadero, Vehiculo vehiculo) throws  Exception{
        parqueadero.setVehiculo(vehiculo);
        parqueadero.setDisponibilidad(false);
        parqueaderoRepository.save(parqueadero);
    }

    @Override
    public void retirarVehiculo (Parqueadero parqueadero) throws  Exception{
        parqueadero.setVehiculo(null);
        parqueadero.setDisponibilidad(true);
        parqueaderoRepository.save(parqueadero);
    }
}
