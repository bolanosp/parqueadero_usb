package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.TiqueteDTO;
import co.edu.usbcali.parqueaderoservice.mapper.TiqueteMapper;
import co.edu.usbcali.parqueaderoservice.models.Tiquete;
import co.edu.usbcali.parqueaderoservice.repository.TiqueteRepository;
import co.edu.usbcali.parqueaderoservice.service.TiqueteService;
import org.springframework.stereotype.Service;

@Service
public class TiqueteServiceImpl implements TiqueteService {

    private final TiqueteRepository tiqueteRepository;

    public TiqueteServiceImpl(TiqueteRepository tiqueteRepository) {
        this.tiqueteRepository = tiqueteRepository;
    }

    @Override
    public TiqueteDTO crearNuevoTiquete (TiqueteDTO tiqueteDTO) throws Exception{
        if(tiqueteDTO == null){
            throw new Exception("Tiquete es nulo");
        }

        //Convertir a entidad
        Tiquete tiquete = TiqueteMapper.dtoToDomain(tiqueteDTO);

        //Guardar entidad
        tiquete = tiqueteRepository.save(tiquete);

        //Convertimos a DTO
        tiqueteDTO = TiqueteMapper.domainToDto(tiquete);

        //Retornamos el TiqueteDTO
        return tiqueteDTO;

    }
}
