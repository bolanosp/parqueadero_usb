package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.VehiculoDTO;
import co.edu.usbcali.parqueaderoservice.mapper.VehiculoMapper;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;
import co.edu.usbcali.parqueaderoservice.repository.VehiculoRepository;
import co.edu.usbcali.parqueaderoservice.service.VehiculoService;
import org.springframework.stereotype.Service;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public VehiculoDTO crearNuevoVehiculo(VehiculoDTO vehiculoDTO) throws Exception{

        if(vehiculoDTO == null){
            throw new Exception("Vehículo es nulo");
        }

        //Convertir a entidad
        Vehiculo vehiculo = VehiculoMapper.dtoToDomain(vehiculoDTO);

        //Guardar entidad
        vehiculo = vehiculoRepository.save(vehiculo);

        //Convertimos a DTO
        vehiculoDTO = VehiculoMapper.domainToDto(vehiculo);

        //Retornamos el VehiculoDTO
        return vehiculoDTO;

    }
}