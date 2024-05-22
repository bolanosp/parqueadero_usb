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
    private final VehiculoRepository vehiculoRepository;

    public ParqueaderoServiceImpl(ParqueaderoRepository parqueaderoRepository, VehiculoRepository vehiculoRepository) {
        this.parqueaderoRepository = parqueaderoRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<ParqueaderoDTO> obtenerParqueaderos () throws Exception{
        List<Parqueadero> parqueaderos = parqueaderoRepository.findAll();
        return ParqueaderoMapper.domainToDtoList(parqueaderos);
    }

    @Override
    public ParqueaderoDTO ingresarVehiculo (Integer idParqueadero, Integer idVehiculo) throws  Exception{
        Parqueadero parqueadero = parqueaderoRepository.getReferenceById(idParqueadero);
        Vehiculo vehiculo = vehiculoRepository.getReferenceById(idVehiculo);
        parqueadero.setVehiculo(vehiculo);
        parqueadero.setDisponibilidad(false);
        parqueaderoRepository.save(parqueadero);
        return ParqueaderoMapper.domainToDto(parqueadero);
    }

    @Override
    public ParqueaderoDTO retirarVehiculo (Integer idParqueadero) throws  Exception{
        Parqueadero parqueadero = parqueaderoRepository.getReferenceById(idParqueadero);
        parqueadero.setVehiculo(null);
        parqueadero.setDisponibilidad(true);
        parqueaderoRepository.save(parqueadero);
        return ParqueaderoMapper.domainToDto(parqueadero);
    }
}
