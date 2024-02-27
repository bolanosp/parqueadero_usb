package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.RolDTO;
import co.edu.usbcali.parqueaderoservice.models.Rol;

public class RolMapper {

    public static Rol dtoToDomain(RolDTO rolDTO){
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setNombre(rolDTO.getNombre());
        return null;
    }

    public static RolDTO domainToDto(Rol rol){
        return null;
    }
}
