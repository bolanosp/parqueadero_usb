package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.VehiculoDTO;
import co.edu.usbcali.parqueaderoservice.mapper.VehiculoMapper;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;
import co.edu.usbcali.parqueaderoservice.repository.VehiculoRepository;
import co.edu.usbcali.parqueaderoservice.service.VehiculoService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public VehiculoDTO crearNuevoVehiculo(VehiculoDTO vehiculoDTO) throws Exception {

        if(vehiculoDTO == null){
            throw new Exception("Vehiculo es nulo");
        }

        Vehiculo vehiculo = VehiculoMapper.dtoToDomain(vehiculoDTO);

        vehiculo = vehiculoRepository.save(vehiculo);

        return VehiculoMapper.domainToDto(vehiculo);
    }

    @Override
    public List<VehiculoDTO> obtenerVehiculos () throws Exception{
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return VehiculoMapper.domainToDtoList(vehiculos);
    }

    @Override
    public VehiculoDTO obtenerVehiculoPorId (Integer id) throws Exception{
        Vehiculo vehiculo = vehiculoRepository.getReferenceById(id);
        return VehiculoMapper.domainToDto(vehiculo);
    }

}