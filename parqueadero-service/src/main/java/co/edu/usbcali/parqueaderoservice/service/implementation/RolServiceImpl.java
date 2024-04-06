package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.RolDTO;
import co.edu.usbcali.parqueaderoservice.mapper.RolMapper;
import co.edu.usbcali.parqueaderoservice.models.Rol;
import co.edu.usbcali.parqueaderoservice.repository.RolRepository;
import co.edu.usbcali.parqueaderoservice.service.RolService;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public RolDTO crearNuevoRol(RolDTO rolDTO) throws  Exception{

        //Validar que rolDTO no sea nulo
        if(rolDTO == null){
            throw new Exception("Rol es nulo");
        }

        //Convertir a entidad
        Rol rol = RolMapper.dtoToDomain(rolDTO);

        //Guardar entidad
        rol = rolRepository.save(rol);

        //Convertimos a DTO
        rolDTO = RolMapper.domainToDto(rol);

        //Retornamos el RolDTO
        return  rolDTO;
    }
}
