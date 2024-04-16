package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.FacturaDTO;
import co.edu.usbcali.parqueaderoservice.mapper.FacturaMapper;
import co.edu.usbcali.parqueaderoservice.models.Factura;
import co.edu.usbcali.parqueaderoservice.repository.FacturaRepository;
import co.edu.usbcali.parqueaderoservice.service.FacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
@CrossOrigin("*")
public class FacturaController {

    //Declarar el Repository para hacer uso
    private final FacturaRepository facturaRepository;

    //Declarar el Service para usarlo
    private final FacturaService facturaService;

    //Inyección de dependencias por Constructor
    public FacturaController(FacturaRepository facturaRepository, FacturaService facturaService) {
        this.facturaRepository = facturaRepository;
        this.facturaService = facturaService;
    }

    @GetMapping(value = "/validarController")
    public String validarController(){
        return "Controlador funcionando correctamente";
    }

    @GetMapping(value = "/obtenerFacturas")
    public List<FacturaDTO> obtenerFacturas(){

        // 1. Consulto TODAS las facturas en DB
        List<Factura> facturas = facturaRepository.findAll();

        //2. Instancio una nueva lista a Dto para retornar el método
        List<FacturaDTO> facturasDto;

        //3. Mapeo las facturas que consultó hacia dto
        facturasDto = FacturaMapper.domainToDtoList(facturas);

        //4. Retorno los dtos transformados
        return  facturasDto;
    }

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<FacturaDTO> buscarPorId(@PathVariable Integer id){
        Factura factura = facturaRepository.getReferenceById(id);
        FacturaDTO facturaDTO = FacturaMapper.domainToDto(factura);
        return new ResponseEntity<>(facturaDTO, HttpStatus.OK);
    }

    @PostMapping(value = "crearNuevaFactura")
    public ResponseEntity<FacturaDTO> crearNuevaFactura(@RequestBody FacturaDTO facturaDTO){
        FacturaDTO facturaDTOresponse = null;
        try {
            facturaDTOresponse = facturaService.crearNuevaFactura(facturaDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(facturaDTOresponse, HttpStatus.OK);
    }

}


