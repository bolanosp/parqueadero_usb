package co.edu.usbcali.parqueaderoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private String documentoIdentificacion;
    private String nombre;
    private String apellido;
    private String contrasena;
}
