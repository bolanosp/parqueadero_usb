package co.edu.usbcali.parqueaderoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDto;
import co.edu.usbcali.parqueaderoservice.models.Usuario;
import co.edu.usbcali.parqueaderoservice.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping
    public UsuarioDto crearUsuario(@RequestBody UsuarioDto usuarioDTO) {
        return usuarioService.crearUsuario(usuarioDTO);
    }

    @GetMapping("/{id}")
    public UsuarioDto obtenerUsuario(@PathVariable Long id) throws Exception {
        return usuarioService.obtenerUsuario(id);
    }

    @PutMapping("/{id}")
    public void actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDTO) throws Exception {
        usuarioDTO.setId(id);
        usuarioService.actualizarUsuario(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }
}