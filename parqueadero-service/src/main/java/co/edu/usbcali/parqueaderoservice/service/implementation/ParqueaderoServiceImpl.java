package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.mapper.ParqueaderoMapper;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;
import co.edu.usbcali.parqueaderoservice.repository.ParqueaderoRepository;
import co.edu.usbcali.parqueaderoservice.service.ParqueaderoService;
import org.springframework.stereotype.Service;

@Service
public class ParqueaderoServiceImpl implements ParqueaderoService {

    private final ParqueaderoRepository parqueaderoRepository;

    public ParqueaderoServiceImpl(ParqueaderoRepository parqueaderoRepository) {
        this.parqueaderoRepository = parqueaderoRepository;
    }

    @Override
    public ParqueaderoDTO crearNuevoParqueadero(ParqueaderoDTO parqueaderoDTO) throws  Exception{
        //Validaciones de atributos

        //Validar que parqueaderoDTO no sea nulo
        if(parqueaderoDTO == null){
            throw new Exception("Parqueadero es nulo");
        }

        //Validar el valor de ubicacion
        if(parqueaderoDTO.getUbicacion() == null || parqueaderoDTO.getUbicacion().isBlank()){
            throw  new Exception("Debe ingresar la ubicación");
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
}
