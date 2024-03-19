package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.mapper.ParqueaderoMapper;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;
import co.edu.usbcali.parqueaderoservice.repository.ParqueaderoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parqueadero")
public class ParqueaderoController {

    //Declarar el Repository para hacer uso
    public final ParqueaderoRepository parqueaderoRepository;

    //Inyección de dependencias por Constructor
    public ParqueaderoController(ParqueaderoRepository parqueaderoRepository) {
        this.parqueaderoRepository = parqueaderoRepository;
    }

    @GetMapping(value = "/validarController")
    public String validarController(){
        return "Controlador funcionando correctamente";
    }

    @GetMapping(value = "/obtenerParqueaderos")
    public List<ParqueaderoDTO> obtenerParqueaderos(){

        // 1. Consulto TODOS los parqueaderos en DB
        List<Parqueadero> parqueaderos = parqueaderoRepository.findAll();

        //2. Instancio una nueva lista a Dto para retornar el método
        List<ParqueaderoDTO> parqueaderosDto;

        //3. Mapeo los parqueaderos que consultó hacia dto
        parqueaderosDto = ParqueaderoMapper.domainToDtoList(parqueaderos);

        //4. Retorno los dtos transformados
        return  parqueaderosDto;
    }

}
