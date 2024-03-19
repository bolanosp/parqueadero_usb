package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.repository.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
}
