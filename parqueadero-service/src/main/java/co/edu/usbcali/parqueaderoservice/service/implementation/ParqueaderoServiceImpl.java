package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.mapper.ParqueaderoMapper;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;
import co.edu.usbcali.parqueaderoservice.repository.ParqueaderoRepository;
import co.edu.usbcali.parqueaderoservice.repository.VehiculoRepository;
import co.edu.usbcali.parqueaderoservice.service.ParqueaderoService;
import co.edu.usbcali.parqueaderoservice.service.VehiculoService;
import org.springframework.stereotype.Service;

@Service
public class ParqueaderoServiceImpl implements ParqueaderoService {

    private final ParqueaderoRepository parqueaderoRepository;
    private final VehiculoService vehiculoService;
    private final VehiculoRepository vehiculoRepository;


    public ParqueaderoServiceImpl(ParqueaderoRepository parqueaderoRepository, VehiculoRepository vehiculoRepository,VehiculoService vehiculoService) {
        this.parqueaderoRepository = parqueaderoRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.vehiculoService = vehiculoService;
    }

    @Override
    public ParqueaderoDTO crearNuevoParqueadero(ParqueaderoDTO parqueaderoDTO) throws  Exception{
        //Validaciones de atributos

        //Validar que parqueaderoDTO no sea nulo
        if(parqueaderoDTO == null){
            throw new Exception("Parqueadero es nulo");
        }

        //Validar ubicación
        if(parqueaderoDTO.getUbicacion() == null || parqueaderoDTO.getUbicacion().isBlank()){
            throw new Exception("Debe ingresar la ubicación");
        }

        //Validar disponibilidad
        if(parqueaderoDTO.getDisponibilidad() == null){
            throw new Exception("Debe ingresar la disponibilidad");
        }

        // Validar vehículo solo si la disponibilidad es false
        if (parqueaderoDTO.getDisponibilidad() == Boolean.FALSE) {
            if (parqueaderoDTO.getVehiculo() == null) {
                throw new Exception("Debe relacionarse con un vehículo válido cuando la disponibilidad es falsa");
            }
            Vehiculo vehiculo = vehiculoService.buscarVehiculoPorId(parqueaderoDTO.getVehiculo());
            if (vehiculo == null) {
                throw new Exception("Vehículo no encontrado en la base de datos");
            }
        }


        //Convertir a entidad
        Parqueadero parqueadero = ParqueaderoMapper.dtoToDomain(parqueaderoDTO);

        //Guardar entidad
        parqueadero = parqueaderoRepository.save(parqueadero);

        //Convertimos a DTO
        parqueaderoDTO = ParqueaderoMapper.domainToDto(parqueadero);

        //Retornamos el ParqueaderoDTO
        return parqueaderoDTO;
    }

    @Override
    public boolean existeVehiculo(Integer idVehiculo) {
        if (idVehiculo == null) {
            return false;
        }
        return vehiculoRepository.existsById(idVehiculo);
    }

    @Override
    public ParqueaderoDTO buscarPorId(Integer id) throws Exception {
        // Implementación para buscar un parqueadero por su ID
        Parqueadero parqueadero = parqueaderoRepository.findById(id)
                .orElseThrow(() -> new Exception("Parqueadero no encontrado"));
        return ParqueaderoMapper.domainToDto(parqueadero);
    }
}
