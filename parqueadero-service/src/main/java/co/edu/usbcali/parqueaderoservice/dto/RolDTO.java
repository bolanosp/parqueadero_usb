package co.edu.usbcali.parqueaderoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolDTO {
    private Integer id;
    private String nombre;
}
