package co.edu.usbcali.parqueaderoservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no puede ser nulo")
    private String nombre;

    @NotEmpty(message = "El apellido no puede ser nulo")
    private String apellido;

    @NotEmpty(message = "El correo electronico no puede ser nulo")
    @Email(message = "El correo electrónico no tiene un formato válido")
    private String correo_electronico;

    @NotEmpty(message = "El nombre de usuario no puede ser nulo")
    private String nombre_usuario;
}
