package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.FacturaDTO;
import co.edu.usbcali.parqueaderoservice.mapper.FacturaMapper;
import co.edu.usbcali.parqueaderoservice.models.Factura;
import co.edu.usbcali.parqueaderoservice.repository.FacturaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    //Declarar el Repository para hacer uso
    public final FacturaRepository facturaRepository;

    //Inyección de dependencias por Constructor
    public FacturaController(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
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

}
