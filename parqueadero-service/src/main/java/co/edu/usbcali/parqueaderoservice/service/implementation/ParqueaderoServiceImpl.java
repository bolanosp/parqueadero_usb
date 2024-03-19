package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.repository.ParqueaderoRepository;
import org.springframework.stereotype.Service;

@Service
public class ParqueaderoServiceImpl{

    private final ParqueaderoRepository parqueaderoRepository;

    public ParqueaderoServiceImpl(ParqueaderoRepository parqueaderoRepository) {
        this.parqueaderoRepository = parqueaderoRepository;
    }
}
