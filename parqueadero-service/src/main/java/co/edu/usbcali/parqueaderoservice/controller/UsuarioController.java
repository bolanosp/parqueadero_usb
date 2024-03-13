package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDTO;
import co.edu.usbcali.parqueaderoservice.mapper.UsuarioMapper;
import co.edu.usbcali.parqueaderoservice.models.Usuario;
import co.edu.usbcali.parqueaderoservice.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    public final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<UsuarioDTO> obtenerUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioDTO> usuariosDTO = null;

        usuariosDTO = UsuarioMapper.domainToDtoList(usuarios);

        return usuariosDTO;
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Integer id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        UsuarioDTO usuarioDTO = UsuarioMapper.domainToDto(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }

    @GetMapping("/buscarPorDocumento/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorDocumento(@PathVariable String documento){
        Usuario usuario = usuarioRepository.findUsuarioByDocumento(documento);
        UsuarioDTO usuarioDTO = UsuarioMapper.domainToDto(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }
}
