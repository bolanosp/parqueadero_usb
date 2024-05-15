package co.edu.usbcali.parqueaderoservice.mapper;

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
    
            return usuario;
        }

}
