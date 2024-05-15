package co.edu.usbcali.parqueaderoservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDto;
import co.edu.usbcali.parqueaderoservice.mapper.UsuarioMapper;
import co.edu.usbcali.parqueaderoservice.models.Usuario;
import co.edu.usbcali.parqueaderoservice.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDto> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioMapper.userToUsersDTO(usuarios);
    }

    public UsuarioDto crearUsuario(UsuarioDto usuarioDTO) {
        Usuario usuario = UsuarioMapper.toUser(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return UsuarioMapper.toUserDTO(usuario);
    }

    public UsuarioDto obtenerUsuario(Long id) throws Exception {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado con ID: " + id));
        return UsuarioMapper.toUserDTO(usuario);
    }

    public UsuarioDto actualizarUsuario(UsuarioDto usuarioDTO) throws Exception {
        Long id = usuarioDTO.getId();
        usuarioRepository.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado con ID: " + id));
        usuarioRepository.save(UsuarioMapper.toUser(usuarioDTO));
        return usuarioDTO;
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
