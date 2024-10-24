package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.RolDTO;
import co.edu.usbcali.parqueaderoservice.models.Rol;

import java.util.List;

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

    public static List<RolDTO> domainToDtoList(List<Rol> roles){
        return roles.stream().map(RolMapper::domainToDto).toList();
    }

    public static List <Rol> dtoToDomainList(List<RolDTO> rolesDto){
        return  rolesDto.stream().map(RolMapper::dtoToDomain).toList();
    }
}
