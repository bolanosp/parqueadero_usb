package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.RolDTO;
import co.edu.usbcali.parqueaderoservice.mapper.RolMapper;
import co.edu.usbcali.parqueaderoservice.models.Rol;
import co.edu.usbcali.parqueaderoservice.repository.RolRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class RolController {

    //Declarar el Repository para hacer uso
    public final RolRepository rolRepository;

    //Inyección de dependencias por Constructor
    public RolController(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
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


}
