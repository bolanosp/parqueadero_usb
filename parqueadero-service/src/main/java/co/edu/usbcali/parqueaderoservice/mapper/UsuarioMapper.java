package co.edu.usbcali.parqueaderoservice.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDto;
import co.edu.usbcali.parqueaderoservice.models.Usuario;

public class UsuarioMapper {

    public static UsuarioDto toUserDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setApellido(usuario.getApellido());
        usuarioDto.setCorreo_electronico(usuario.getCorreo_electronico());
        usuarioDto.setNombre_usuario(usuario.getNombre_usuario());

        return usuarioDto;
    }

    public static Usuario toUser(UsuarioDto usuarioDto) {
        if (usuarioDto == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setId(usuarioDto.getId());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        usuario.setCorreo_electronico(usuarioDto.getCorreo_electronico());
        usuario.setNombre_usuario(usuarioDto.getNombre_usuario());

        return usuario;
    }

    public static List<UsuarioDto> userToUsersDTO(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioMapper::toUserDTO).collect(Collectors.toList());
    }
}
