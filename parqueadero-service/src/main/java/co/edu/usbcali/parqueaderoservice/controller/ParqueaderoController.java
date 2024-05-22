package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.dto.TiqueteDTO;
import co.edu.usbcali.parqueaderoservice.service.ParqueaderoService;
import co.edu.usbcali.parqueaderoservice.service.TiqueteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parqueaderos")
@CrossOrigin("*")
public class ParqueaderoController {

    private final ParqueaderoService parqueaderoService;
    private final TiqueteService tiqueteService;

    public ParqueaderoController(ParqueaderoService parqueaderoService,
            TiqueteService tiqueteService) {
        this.parqueaderoService = parqueaderoService;
        this.tiqueteService = tiqueteService;
    }

    @GetMapping
    public ResponseEntity<List<ParqueaderoDTO>> obtenerParqueaderos() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(parqueaderoService.obtenerParqueaderos());
    }

    @PostMapping("/ingreso/{idParqueadero}/{idVehiculo}")
    public ResponseEntity<TiqueteDTO> ingresarVehiculo(@PathVariable Integer idParqueadero,
            @PathVariable Integer idVehiculo) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tiqueteService.ingresarVehiculo(idParqueadero, idVehiculo));
    }

    @PutMapping("/salida/{idTiquete}")
    public ResponseEntity<TiqueteDTO> retirarVehiculo(@PathVariable Integer idTiquete) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(tiqueteService.retirarVehiculo(idTiquete));
    }
}
