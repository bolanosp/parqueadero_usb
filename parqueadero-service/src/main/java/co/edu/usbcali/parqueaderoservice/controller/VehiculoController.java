package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.VehiculoDTO;
import co.edu.usbcali.parqueaderoservice.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin("*")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public ResponseEntity<List<VehiculoDTO>> obtenerVehiculos() throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.obtenerVehiculos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> buscarPorId(@PathVariable Integer id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.obtenerVehiculoPorId(id));
    }

    @PostMapping
    public ResponseEntity<VehiculoDTO> crearNuevoVehiculo(@RequestBody VehiculoDTO vehiculoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoService.crearNuevoVehiculo(vehiculoDTO));
    }

}
