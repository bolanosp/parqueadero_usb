package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.service.ParqueaderoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parqueaderos")
@CrossOrigin("*")
public class ParqueaderoController {

    private final ParqueaderoService parqueaderoService;

    public ParqueaderoController(ParqueaderoService parqueaderoService) {
        this.parqueaderoService = parqueaderoService;
    }

    @GetMapping
    public ResponseEntity<List<ParqueaderoDTO>> obtenerParqueaderos() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(parqueaderoService.obtenerParqueaderos());
    }

    @PutMapping("/ingreso/{idParqueadero}/{idVehiculo}")
    public ResponseEntity<ParqueaderoDTO> ingresarVehiculo(@PathVariable Integer idParqueadero, @PathVariable Integer idVehiculo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(parqueaderoService.ingresarVehiculo(idParqueadero, idVehiculo));
    }

    @PutMapping("/salida/{idParqueadero}")
    public ResponseEntity<ParqueaderoDTO> retirarVehiculo(@PathVariable Integer idParqueadero) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(parqueaderoService.retirarVehiculo(idParqueadero));
    }
}
