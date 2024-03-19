package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.TipoVehiculoDTO;
import co.edu.usbcali.parqueaderoservice.dto.TiqueteDTO;
import co.edu.usbcali.parqueaderoservice.mapper.TiqueteMapper;
import co.edu.usbcali.parqueaderoservice.models.Tiquete;
import co.edu.usbcali.parqueaderoservice.repository.TiqueteRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class TiqueteController {


    //Declarar el Repository para hacer uso
    public final TiqueteRepository tiqueteRepository;

    //Inyección de dependencias por Constructor
    public TiqueteController(TiqueteRepository tiqueteRepository) {
        this.tiqueteRepository = tiqueteRepository;
    }

    @GetMapping(value = "/validarController")
    public String validarController(){
        return "Controlador funcionando correctamente";
    }

    @GetMapping(value = "/obtenerTiquete")
    public List<TiqueteDTO> obtenerTiquete(){

        // 1. Consulto TODOS los tiquetes en DB
        List<Tiquete> tiquetes = tiqueteRepository.findAll();

        //2. Instancio una nueva lista a Dto para retornar el método
        List<TiqueteDTO> tiquetesDto;

        //3. Mapeo los tiquetes que consultó hacia dto
        tiquetesDto = TiqueteMapper.domainToDtoList(tiquetes);

        //4. Retorno los dtos transformados
        return  tiquetesDto;
    }

}
