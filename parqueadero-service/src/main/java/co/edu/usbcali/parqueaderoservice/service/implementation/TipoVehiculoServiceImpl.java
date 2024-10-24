package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.TipoVehiculoDTO;
import co.edu.usbcali.parqueaderoservice.mapper.TipoVehiculoMapper;
import co.edu.usbcali.parqueaderoservice.models.TipoVehiculo;
import co.edu.usbcali.parqueaderoservice.repository.TipoVehiculoRepository;
import co.edu.usbcali.parqueaderoservice.service.TipoVehiculoService;
import org.springframework.stereotype.Service;

@Service
public class TipoVehiculoServiceImpl implements TipoVehiculoService {

    private final TipoVehiculoRepository tipoVehiculoRepository;

    public TipoVehiculoServiceImpl(TipoVehiculoRepository tipoVehiculoRepository) {
        this.tipoVehiculoRepository = tipoVehiculoRepository;
    }

    @Override
    public TipoVehiculoDTO crearNuevoTipoVehiculo(TipoVehiculoDTO tipoVehiculoDTO) throws Exception{


        //Validar que tipoVehiculoDTO no sea nulo
        if(tipoVehiculoDTO == null){
            throw new Exception("Tipo Vehiculo es nulo");
        }

        //Convertir a entidad
        TipoVehiculo tipoVehiculo = TipoVehiculoMapper.dtoToDomain(tipoVehiculoDTO);

        //Guardar entidad
        tipoVehiculo = tipoVehiculoRepository.save(tipoVehiculo);

        //Convertimos a DTO
        tipoVehiculoDTO = TipoVehiculoMapper.domainToDto(tipoVehiculo);

        //Retornamos el TipoVehiculoDTO
        return tipoVehiculoDTO;

    }
}
