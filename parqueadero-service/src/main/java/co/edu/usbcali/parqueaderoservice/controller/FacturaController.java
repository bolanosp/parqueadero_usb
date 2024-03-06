package co.edu.usbcali.parqueaderoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @GetMapping(value = "validarController")
    public String validarController(){
        return "Controlador funcionando correctamente";
    }

}
