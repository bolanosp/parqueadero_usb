package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.TiqueteDTO;
import co.edu.usbcali.parqueaderoservice.mapper.TiqueteMapper;
import co.edu.usbcali.parqueaderoservice.models.Tiquete;
import co.edu.usbcali.parqueaderoservice.repository.TiqueteRepository;
import co.edu.usbcali.parqueaderoservice.service.TiqueteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class TiqueteController {


    //Declarar el Repository y el Service para hacer uso
    private final TiqueteRepository tiqueteRepository;
    private final TiqueteService tiqueteService;

    //Inyección de dependencias por Constructor
    public TiqueteController(TiqueteRepository tiqueteRepository, TiqueteService tiqueteService) {
        this.tiqueteRepository = tiqueteRepository;
        this.tiqueteService = tiqueteService;
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

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<TiqueteDTO> buscarPorId(@PathVariable Integer id){
        Tiquete tiquete = tiqueteRepository.getReferenceById(id);
        TiqueteDTO tiqueteDTO = TiqueteMapper.domainToDto(tiquete);
        return new ResponseEntity<>(tiqueteDTO, HttpStatus.OK);
    }

    @PostMapping(value = "crearNuevoTiquete")
    public ResponseEntity<TiqueteDTO> crearNuevoTiquete(@RequestBody TiqueteDTO tiqueteDTO){
        TiqueteDTO tiqueteDTOresponse = null;
        try {
            tiqueteDTOresponse = tiqueteService.crearNuevoTiquete(tiqueteDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(tiqueteDTOresponse, HttpStatus.OK);
    }

}
