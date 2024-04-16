package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.TipoVehiculoDTO;
import co.edu.usbcali.parqueaderoservice.dto.TiqueteDTO;
import co.edu.usbcali.parqueaderoservice.mapper.TipoVehiculoMapper;
import co.edu.usbcali.parqueaderoservice.models.TipoVehiculo;
import co.edu.usbcali.parqueaderoservice.repository.TipoVehiculoRepository;
import co.edu.usbcali.parqueaderoservice.service.TipoVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_vehiculo")
@CrossOrigin("*")
public class TipoVehiculoController {

    //Declarar el Repository y el Service para hacer uso
    private final TipoVehiculoRepository tipoVehiculoRepository;
    private final TipoVehiculoService tipoVehiculoService;

    //Inyección de dependencias por Constructor
    public TipoVehiculoController(TipoVehiculoRepository tipoVehiculoRepository, TipoVehiculoService tipoVehiculoService) {
        this.tipoVehiculoRepository = tipoVehiculoRepository;
        this.tipoVehiculoService = tipoVehiculoService;
    }

    @GetMapping(value = "/validarController")
    public String validarController(){
        return "Controlador funcionando correctamente";
    }

    @GetMapping(value = "/obtenerTipoVehiculo")
    public List<TipoVehiculoDTO> obtenerTipoVehiculo(){

        // 1. Consulto TODOS los tipos de vehiculo en DB
        List<TipoVehiculo> tipoVehiculos = tipoVehiculoRepository.findAll();

        //2. Instancio una nueva lista a Dto para retornar el método
        List<TipoVehiculoDTO> tipoVehiculosDto;

        //3. Mapeo los tipos vehiculo que consultó hacia dto
        tipoVehiculosDto = TipoVehiculoMapper.domainToDtoList(tipoVehiculos);

        //4. Retorno los dtos transformados
        return  tipoVehiculosDto;
    }

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<TipoVehiculoDTO> buscarPorId(@PathVariable Integer id){
        TipoVehiculo tipoVehiculo = tipoVehiculoRepository.getReferenceById(id);
        TipoVehiculoDTO tipoVehiculoDTO = TipoVehiculoMapper.domainToDto(tipoVehiculo);
        return new ResponseEntity<>(tipoVehiculoDTO, HttpStatus.OK);
    }

    @PostMapping(value = "crearNuevoTipoVehiculo")
    public ResponseEntity<TipoVehiculoDTO> crearNuevoTipoVehiculo(@RequestBody TipoVehiculoDTO tipoVehiculoDTO){
        TipoVehiculoDTO tipoVehiculoDTOresponse = null;
        try {
            tipoVehiculoDTOresponse = tipoVehiculoService.crearNuevoTipoVehiculo(tipoVehiculoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(tipoVehiculoDTOresponse, HttpStatus.OK);
    }

}
