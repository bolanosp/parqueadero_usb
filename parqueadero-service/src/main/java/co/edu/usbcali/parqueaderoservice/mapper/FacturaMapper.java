package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.FacturaDTO;
import co.edu.usbcali.parqueaderoservice.models.Factura;

import java.util.List;

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

    public List <FacturaDTO> domainToDtoList(List<Factura> facturas){
        return facturas.stream().map(FacturaMapper::domainToDto).toList();
    }

    public List <Factura> dtoToDomainList(List<FacturaDTO> facturasDto){
        return  facturasDto.stream().map(FacturaMapper::dtoToDomain).toList();
    }
}
