package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.FacturaDTO;
import co.edu.usbcali.parqueaderoservice.dto.RolDTO;
import co.edu.usbcali.parqueaderoservice.mapper.RolMapper;
import co.edu.usbcali.parqueaderoservice.models.Rol;
import co.edu.usbcali.parqueaderoservice.repository.RolRepository;
import co.edu.usbcali.parqueaderoservice.service.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class RolController {

    //Declarar el Repository para hacer uso
    private final RolRepository rolRepository;

    //Declarar el Service para usarlo
    private final RolService rolService;

    //Inyección de dependencias por Constructor
    public RolController(RolRepository rolRepository, RolService rolService) {
        this.rolRepository = rolRepository;
        this.rolService = rolService;
    }

    @GetMapping(value = "/validarController")
    public String validarController(){
        return "Controlador funcionando correctamente";
    }

    @GetMapping(value = "/obtenerRoles")
    public List<RolDTO> obtenerRoles(){

        // 1. Consulto TODAS los roles en DB
        List<Rol> roles = rolRepository.findAll();

        //2. Instancio una nueva lista a Dto para retornar el método
        List<RolDTO> rolesDto;

        //3. Mapeo los roles que consultó hacia dto
        rolesDto = RolMapper.domainToDtoList(roles);

        //4. Retorno los dtos transformados
        return  rolesDto;
    }

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<RolDTO> buscarPorId(@PathVariable Integer id){
        Rol rol = rolRepository.getReferenceById(id);
        RolDTO rolDTO = RolMapper.domainToDto(rol);
        return new ResponseEntity<>(rolDTO, HttpStatus.OK);
    }

    @PostMapping(value = "crearNuevoRol")
    public ResponseEntity<RolDTO> crearNuevoRol(@RequestBody RolDTO rolDTO){
        RolDTO rolDTOresponse = null;
        try {
            rolDTOresponse = rolService.crearNuevoRol(rolDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(rolDTOresponse, HttpStatus.OK);
    }


}
