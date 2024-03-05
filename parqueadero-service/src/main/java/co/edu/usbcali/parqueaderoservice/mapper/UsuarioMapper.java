package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDTO;
import co.edu.usbcali.parqueaderoservice.models.Usuario;

import java.util.List;

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

    public static List<UsuarioDTO> domainToDtoList (List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioMapper::domainToDto).toList();
    }

    public static List<Usuario> dtoToDomainList (List<UsuarioDTO> usuarioDTOS){
        return usuarioDTOS.stream().map(UsuarioMapper::dtoToDomain).toList();
    }
}
