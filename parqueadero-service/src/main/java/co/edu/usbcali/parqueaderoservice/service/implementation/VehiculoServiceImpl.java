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
    public VehiculoDTO crearNuevoVehiculo(VehiculoDTO vehiculoDTO) throws Exception {



        // Validar que vehiculoDTO no sea nulo
        if (vehiculoDTO == null) {
            throw new Exception("Vehículo es nulo");
        }

        // Convertir a entidad
        Vehiculo vehiculo = VehiculoMapper.dtoToDomain(vehiculoDTO);

        // Guardar entidad
        vehiculo = vehiculoRepository.save(vehiculo);

        // Convertir entidad guardada a DTO
        VehiculoDTO vehiculoGuardadoDTO = VehiculoMapper.domainToDto(vehiculo);

        // Retornar el VehiculoDTO guardado
        return vehiculoGuardadoDTO;
    }

    @Override
    public Vehiculo buscarVehiculoPorId(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("No se puede consultar el ID");
        }
        return vehiculoRepository.getReferenceById(id);
    }



}