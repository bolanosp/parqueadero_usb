package co.edu.usbcali.parqueaderoservice.service;

import java.util.List;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDTO;

public interface UsuarioService {

    UsuarioDTO crearNuevoUsuario (UsuarioDTO usuarioDTO) throws Exception;

    List<UsuarioDTO> obtenerUsuarios () throws Exception;

    UsuarioDTO obtenerUsuarioPorId (Integer id) throws Exception;
}
