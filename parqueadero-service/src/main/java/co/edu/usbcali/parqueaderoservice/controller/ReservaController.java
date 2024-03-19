package co.edu.usbcali.parqueaderoservice.controller;

import co.edu.usbcali.parqueaderoservice.dto.ReservaDTO;
import co.edu.usbcali.parqueaderoservice.mapper.ReservaMapper;
import co.edu.usbcali.parqueaderoservice.models.Reserva;
import co.edu.usbcali.parqueaderoservice.repository.ReservaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ReservaController {

    //Declarar el Repository para hacer uso
    public final ReservaRepository reservaRepository;

    //Inyección de dependencias por Constructor
    public ReservaController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @GetMapping(value = "/validarController")
    public String validarController(){
        return "Controlador funcionando correctamente";
    }

    @GetMapping(value = "/obtenerReservas")
    public List<ReservaDTO> obtenerReservas(){

        // 1. Consulto TODAS las reservas en DB
        List<Reserva> reservas = reservaRepository.findAll();

        //2. Instancio una nueva lista a Dto para retornar el método
        List<ReservaDTO> reservasDto;

        //3. Mapeo las reservas que consultó hacia dto
        reservasDto = ReservaMapper.domainToDtoList(reservas);

        //4. Retorno los dtos transformados
        return  reservasDto;
    }

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<ReservaDTO> buscarPorId(@PathVariable Integer id){
        Reserva reserva = reservaRepository.getReferenceById(id);
        ReservaDTO reservaDTO = ReservaMapper.domainToDto(reserva);
        return new ResponseEntity<>(reservaDTO, HttpStatus.OK);
    }

}
