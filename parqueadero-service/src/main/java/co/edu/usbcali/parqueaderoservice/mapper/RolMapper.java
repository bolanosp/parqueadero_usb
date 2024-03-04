package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.RolDTO;
import co.edu.usbcali.parqueaderoservice.models.Rol;

public class RolMapper {
    public static RolDTO domainToDto(Rol rol){
        return RolDTO
                .builder()
                .id(rol.getId())
                .nombre(rol.getNombre())
                .build();
    }

    public static Rol dtoToDomain(RolDTO rolDTO){
        return Rol
                .builder()
                .id(rolDTO.getId())
                .nombre(rolDTO.getNombre())
                .build();
    }
}
