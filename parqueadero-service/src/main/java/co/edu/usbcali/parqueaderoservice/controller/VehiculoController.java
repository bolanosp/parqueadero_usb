package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.VehiculoDTO;
import co.edu.usbcali.parqueaderoservice.mapper.VehiculoMapper;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;
import co.edu.usbcali.parqueaderoservice.repository.VehiculoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class VehiculoController {


    //Declarar el Repository para hacer uso
    private final VehiculoRepository vehiculoRepository;

    //Inyección de dependencias por Constructor
    public VehiculoController(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @GetMapping(value = "/validarController")
    public String validarController(){
        return "Controlador funcionando correctamente";
    }

    @GetMapping(value = "/obtenerVehiculo")
    public List<VehiculoDTO> obtenerVehiculo(){

        // 1. Consulto TODOS los vehiculos en DB
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();

        //2. Instancio una nueva lista a Dto para retornar el método
        List<VehiculoDTO> vehiculosDto;

        //3. Mapeo los vehiculos que consultó hacia dto
        vehiculosDto = VehiculoMapper.domainToDtoList(vehiculos);

        //4. Retorno los dtos transformados
        return  vehiculosDto;
    }

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<VehiculoDTO> buscarPorId(@PathVariable Integer id){
        Vehiculo vehiculo = vehiculoRepository.getReferenceById(id);
        VehiculoDTO vehiculoDTO = VehiculoMapper.domainToDto(vehiculo);
        return new ResponseEntity<>(vehiculoDTO, HttpStatus.OK);
    }

}
