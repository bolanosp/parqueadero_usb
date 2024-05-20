package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDTO;
import co.edu.usbcali.parqueaderoservice.models.Usuario;

import java.util.List;

public class UsuarioMapper {
    public static UsuarioDTO domainToDto(Usuario usuario){
        UsuarioDTO usuarioDTO = UsuarioDTO
                .builder()
                .id(usuario.getId())
                .documentoIdentificacion(usuario.getDocumentoIdentificacion())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .contrasena(usuario.getContrasena())
                .build();

        return usuarioDTO;
    }

    public static Usuario dtoToDomain(UsuarioDTO usuarioDTO){

        Usuario usuario = Usuario.builder()
                .id(usuarioDTO.getId())
                .documentoIdentificacion(usuarioDTO.getDocumentoIdentificacion())
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .contrasena(usuarioDTO.getContrasena())
                .build();

        return usuario;
    }

    public static List<UsuarioDTO> domainToDtoList (List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioMapper::domainToDto).toList();
    }

    public static List<Usuario> dtoToDomainList (List<UsuarioDTO> usuarioDTOS){
        return usuarioDTOS.stream().map(UsuarioMapper::dtoToDomain).toList();
    }
}
