package co.edu.usbcali.parqueaderoservice.repository;

import co.edu.usbcali.parqueaderoservice.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
