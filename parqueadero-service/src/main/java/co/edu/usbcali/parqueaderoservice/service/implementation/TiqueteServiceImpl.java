package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.TiqueteDTO;
import co.edu.usbcali.parqueaderoservice.mapper.TiqueteMapper;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;
import co.edu.usbcali.parqueaderoservice.models.Tiquete;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;
import co.edu.usbcali.parqueaderoservice.repository.ParqueaderoRepository;
import co.edu.usbcali.parqueaderoservice.repository.TiqueteRepository;
import co.edu.usbcali.parqueaderoservice.repository.VehiculoRepository;
import co.edu.usbcali.parqueaderoservice.service.ParqueaderoService;
import co.edu.usbcali.parqueaderoservice.service.TiqueteService;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TiqueteServiceImpl implements TiqueteService {

    private final TiqueteRepository tiqueteRepository;
    private final ParqueaderoRepository parqueaderoRepository;
    private final VehiculoRepository vehiculoRepository;
    private final ParqueaderoService parqueaderoService;

    public TiqueteServiceImpl(TiqueteRepository tiqueteRepository,
            ParqueaderoRepository parqueaderoRepository,
            VehiculoRepository vehiculoRepository,
            ParqueaderoService parqueaderoService) {
        this.tiqueteRepository = tiqueteRepository;
        this.parqueaderoRepository = parqueaderoRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.parqueaderoService = parqueaderoService;
    }

    @Override
    public TiqueteDTO ingresarVehiculo(Integer idParqueadero, Integer idVehiculo) throws Exception {
        Parqueadero parqueadero = parqueaderoRepository.getReferenceById(idParqueadero);
        Vehiculo vehiculo = vehiculoRepository.getReferenceById(idVehiculo);
        Tiquete tiquete = new Tiquete();
        parqueaderoService.ingresarVehiculo(parqueadero, vehiculo);
        tiquete.setVehiculo(vehiculo);
        tiquete.setParqueadero(parqueadero);
        tiquete.setHoraEntrada(new Date());
        tiqueteRepository.save(tiquete);
        return TiqueteMapper.domainToDto(tiquete);
    }

    @Override
    public TiqueteDTO retirarVehiculo(Integer idTiquete) throws Exception {
        Tiquete tiquete = tiqueteRepository.getReferenceById(idTiquete);
        parqueaderoService.retirarVehiculo(tiquete.getParqueadero());
        tiquete.setHoraSalida(new Date());
        tiquete.setValor(calcularPrecio(tiquete));
        tiqueteRepository.save(tiquete);
        return TiqueteMapper.domainToDto(tiquete);
    }

    private Double calcularPrecio(Tiquete tiquete){
        double precio;

        Instant entrada = tiquete.getHoraEntrada().toInstant();
        Instant salida = tiquete.getHoraSalida().toInstant();

        Duration duracion = Duration.between(entrada, salida);

        precio = ((tiquete.getVehiculo().getTipoVehiculo().getTarifa()) * (duracion.toHours()) + 3000);

        return precio;
    }
}
