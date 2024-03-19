package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.repository.RolRepository;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl {
    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
}
