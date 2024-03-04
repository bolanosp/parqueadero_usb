package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.FacturaDTO;
import co.edu.usbcali.parqueaderoservice.dto.ParqueaderoDTO;
import co.edu.usbcali.parqueaderoservice.models.Factura;
import co.edu.usbcali.parqueaderoservice.models.Parqueadero;

public class FacturaMapper {
    public static FacturaDTO domainToDto(Factura factura){
        return FacturaDTO
                .builder()
                .id(factura.getId())
                .valor(factura.getValor())
                .build();
    }

    public static Factura dtoToDomain(FacturaDTO facturaDTO){
        return Factura
                .builder()
                .id(facturaDTO.getId())
                .valor(facturaDTO.getValor())
                .build();
    }
}
