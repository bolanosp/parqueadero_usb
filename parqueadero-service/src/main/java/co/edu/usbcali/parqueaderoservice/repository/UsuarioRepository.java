package co.edu.usbcali.parqueaderoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.parqueaderoservice.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

