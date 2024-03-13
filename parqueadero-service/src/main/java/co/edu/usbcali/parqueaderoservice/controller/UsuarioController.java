package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.UsuarioDTO;
import co.edu.usbcali.parqueaderoservice.mapper.UsuarioMapper;
import co.edu.usbcali.parqueaderoservice.models.Usuario;
import co.edu.usbcali.parqueaderoservice.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class UsuarioController {


    //Declarar el Repository para hacer uso
    public final UsuarioRepository usuarioRepository;

    //Inyección de dependencias por Constructor
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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

}
