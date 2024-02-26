package co.edu.usbcali.parqueaderoservice.repository;

import co.edu.usbcali.parqueaderoservice.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

}
