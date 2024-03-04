package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDTO;
import co.edu.usbcali.parqueaderoservice.models.Usuario;

public class UsuarioMapper {
    public static Usuario dtoToDomain(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setDocumentoIdentificacion(usuarioDTO.getDocumentoIdentificacion());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setContrasena(usuarioDTO.getContrasena());
        return null;
    }

    public static UsuarioDTO domainToDto(Usuario usuario){
        return null;
    }
}
