package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDTO;
import co.edu.usbcali.parqueaderoservice.mapper.UsuarioMapper;
import co.edu.usbcali.parqueaderoservice.models.Usuario;
import co.edu.usbcali.parqueaderoservice.repository.UsuarioRepository;
import co.edu.usbcali.parqueaderoservice.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDTO crearNuevoUsuario (UsuarioDTO usuarioDTO) throws Exception{

        System.out.println("Creando nuevo usuario: " + usuarioDTO);

        //Validar que usuarioDTO no sea nulo
        if(usuarioDTO == null){
            throw new Exception("Usuario es nulo");
        }

        //Convertir a entidad
        Usuario usuario = UsuarioMapper.dtoToDomain(usuarioDTO);

        //Guardar entidad
        usuario = usuarioRepository.save(usuario);

        //Convertimos a DTO
        usuarioDTO = UsuarioMapper.domainToDto(usuario);

        //Retornamos el UsuarioDTO
        return usuarioDTO;

    }
}
