package co.edu.usbcali.parqueaderoservice.service.implementation;

import co.edu.usbcali.parqueaderoservice.dto.FacturaDTO;
import co.edu.usbcali.parqueaderoservice.mapper.FacturaMapper;
import co.edu.usbcali.parqueaderoservice.models.Factura;
import co.edu.usbcali.parqueaderoservice.repository.FacturaRepository;
import co.edu.usbcali.parqueaderoservice.service.FacturaService;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public FacturaDTO crearNuevaFactura(FacturaDTO facturaDTO) throws Exception {

        //Validaciones de atributos

        //Validar que facturaDTO no sea nulo
        if(facturaDTO == null){
            throw  new Exception("Factura es nulo");
        }

        //Validar el valor de la factura a crear
        if(facturaDTO.getValor() == null || facturaDTO.getValor() == 0){
            throw new Exception("Debe ingresar el valor");
        }

        //Convertir a entidad
        Factura factura = FacturaMapper.dtoToDomain(facturaDTO);

        //Guardar entidad
        factura = facturaRepository.save(factura);

        //Convertimos a DTO
        facturaDTO = FacturaMapper.domainToDto(factura);

        //Retornamos el FacturaDTO
        return facturaDTO;
    }
}
