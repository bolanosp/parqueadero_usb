package co.edu.usbcali.parqueaderoservice.repository;

import co.edu.usbcali.parqueaderoservice.models.Tiquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiqueteRepository extends JpaRepository<Tiquete, Integer> {
}
