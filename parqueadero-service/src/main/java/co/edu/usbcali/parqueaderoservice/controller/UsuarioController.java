package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDTO;
import co.edu.usbcali.parqueaderoservice.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    // Declarar el Repository y Service para hacer uso
    private final UsuarioService usuarioService;

    // Inyección de dependencias por Constructor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerUsuarios() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.obtenerUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable Integer id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.obtenerUsuarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crearNuevoUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearNuevoUsuario(usuarioDTO));
    }

}
