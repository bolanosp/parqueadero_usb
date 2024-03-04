package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDTO;
import co.edu.usbcali.parqueaderoservice.models.Usuario;

public class UsuarioMapper {
    public static UsuarioDTO domainToDto(Usuario usuario){
        return UsuarioDTO
                .builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .contrasena(usuario.getContrasena())
                .build();
    }

    public static Usuario dtoToDomain(UsuarioDTO usuarioDTO){
        return Usuario
                .builder()
                .id(usuarioDTO.getId())
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .contrasena(usuarioDTO.getContrasena())
                .build();
    }
}
