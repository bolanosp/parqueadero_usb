package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.repository.TiqueteRepository;
import org.springframework.stereotype.Service;

@Service
public class TiqueteServiceImpl {

    private final TiqueteRepository tiqueteRepository;

    public TiqueteServiceImpl(TiqueteRepository tiqueteRepository) {
        this.tiqueteRepository = tiqueteRepository;
    }
}
