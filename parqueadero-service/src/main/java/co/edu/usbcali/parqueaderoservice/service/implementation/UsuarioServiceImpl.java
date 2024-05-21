package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDTO;
import co.edu.usbcali.parqueaderoservice.mapper.UsuarioMapper;
import co.edu.usbcali.parqueaderoservice.models.Usuario;
import co.edu.usbcali.parqueaderoservice.repository.UsuarioRepository;
import co.edu.usbcali.parqueaderoservice.service.UsuarioService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDTO crearNuevoUsuario (UsuarioDTO usuarioDTO) throws Exception{

        if(usuarioDTO == null){
            throw new Exception("Usuario es nulo");
        }

        Usuario usuario = UsuarioMapper.dtoToDomain(usuarioDTO);

        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.domainToDto(usuario);
    }

    @Override
    public List<UsuarioDTO> obtenerUsuarios () throws Exception{
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioMapper.domainToDtoList(usuarios);
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorId (Integer id) throws Exception{
        Usuario usuario = usuarioRepository.getReferenceById(id);
        return UsuarioMapper.domainToDto(usuario);
    }
}
