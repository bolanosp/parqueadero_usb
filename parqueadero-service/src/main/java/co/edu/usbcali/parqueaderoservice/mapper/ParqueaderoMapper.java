package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.FacturaDTO;
import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.models.Factura;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;

public class ParqueaderoMapper {
    public static Parqueadero dtoToDomain(ParqueaderoDTO parqueaderoDTO){
        Parqueadero parqueadero = new Parqueadero();
        parqueadero.setId(parqueaderoDTO.getId());
        parqueadero.setUbicacion(parqueaderoDTO.getUbicacion());
        parqueadero.setDisponibilidad(parqueaderoDTO.getDisponibilidad());
        parqueadero.setVehiculo(parqueaderoDTO.getVehiculo());
        return null;
    }

    public static FacturaDTO domainToDto(Factura factura){
        return null;
    }
}
