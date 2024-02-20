package co.edu.usbcali.parqueaderoservice.repository;

import co.edu.usbcali.parqueaderoservice.models.Parqueadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Integer> {

}
