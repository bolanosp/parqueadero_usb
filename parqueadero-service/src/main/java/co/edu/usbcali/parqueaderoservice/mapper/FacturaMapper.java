package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.FacturaDTO;
import co.edu.usbcali.parqueaderoservice.models.Factura;

public class FacturaMapper {

    public static Factura dtoToDomain(FacturaDTO facturaDTO){
        Factura factura = new Factura();
        factura.setId(facturaDTO.getId());
        factura.setValor(facturaDTO.getValor());

        return null;
    }

    public static FacturaDTO domainToDto(Factura factura){
        return null;
    }

}
