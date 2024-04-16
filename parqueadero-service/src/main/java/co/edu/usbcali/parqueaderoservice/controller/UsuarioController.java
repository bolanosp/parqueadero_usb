package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDTO;
import co.edu.usbcali.parqueaderoservice.mapper.UsuarioMapper;
import co.edu.usbcali.parqueaderoservice.models.Usuario;
import co.edu.usbcali.parqueaderoservice.repository.UsuarioRepository;
import co.edu.usbcali.parqueaderoservice.service.ReservaService;
import co.edu.usbcali.parqueaderoservice.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {


    //Declarar el Repository y Service para hacer uso
    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    //Inyección de dependencias por Constructor
    public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "/validarController")
    public String validarController(){
        return "Controlador funcionando correctamente";
    }

    @GetMapping(value = "/obtenerUsuario")
    public List<UsuarioDTO> obtenerUsuario(){

        // 1. Consulto TODOS los usuarios en DB
        List<Usuario> usuarios = usuarioRepository.findAll();

        //2. Instancio una nueva lista a Dto para retornar el método
        List<UsuarioDTO> usuariosDto;

        //3. Mapeo los tipos vehiculo que consultó hacia dto
        usuariosDto = UsuarioMapper.domainToDtoList(usuarios);

        //4. Retorno los dtos transformados
        return  usuariosDto;
    }

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Integer id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        UsuarioDTO usuarioDTO = UsuarioMapper.domainToDto(usuario);
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }

    @PostMapping(value = "crearNuevoUsuario")
    public ResponseEntity<UsuarioDTO> crearNuevoUsuario(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuarioDTOresponse = null;
        try {
            usuarioDTOresponse = usuarioService.crearNuevoUsuario(usuarioDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(usuarioDTOresponse, HttpStatus.OK);
    }

}
