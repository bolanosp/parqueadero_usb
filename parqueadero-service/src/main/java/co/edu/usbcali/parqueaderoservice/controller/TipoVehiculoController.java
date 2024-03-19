package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.TipoVehiculoDTO;
import co.edu.usbcali.parqueaderoservice.mapper.TipoVehiculoMapper;
import co.edu.usbcali.parqueaderoservice.models.TipoVehiculo;
import co.edu.usbcali.parqueaderoservice.repository.TipoVehiculoRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class TipoVehiculoController {

    //Declarar el Repository para hacer uso
    public final TipoVehiculoRepository tipoVehiculoRepository;

    //Inyección de dependencias por Constructor
    public TipoVehiculoController(TipoVehiculoRepository tipoVehiculoRepository) {
        this.tipoVehiculoRepository = tipoVehiculoRepository;
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

}
