package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.ReservaDTO;
import co.edu.usbcali.parqueaderoservice.mapper.ReservaMapper;
import co.edu.usbcali.parqueaderoservice.models.Reserva;
import co.edu.usbcali.parqueaderoservice.repository.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
    @Override
    public ReservaDTO crearNuevaReserva (ReservaDTO reservaDTO) throws Exception{
        if(reservaDTO == null){
            throw new Exception("Reserva es nulo");
        }

        //Convertir a entidad
        Reserva reserva = ReservaMapper.dtoToDomain(reservaDTO);

        //Guardar entidad
        reserva = reservaRepository.save(reserva);

        //Converyimos a DTO
        reservaDTO = ReservaMapper.domainToDto(reserva);

        //Retornamos el ReservaDTO
        return reservaDTO;


    }
}
