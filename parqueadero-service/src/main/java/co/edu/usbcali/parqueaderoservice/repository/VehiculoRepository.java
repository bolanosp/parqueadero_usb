package co.edu.usbcali.parqueaderoservice.repository;

import co.edu.usbcali.parqueaderoservice.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
}
