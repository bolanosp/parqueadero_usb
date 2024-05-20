package co.edu.usbcali.parqueaderoservice.mapper;

import co.edu.usbcali.parqueaderoservice.dto.VehiculoDTO;
import co.edu.usbcali.parqueaderoservice.models.TipoVehiculo;
import co.edu.usbcali.parqueaderoservice.models.Usuario;
import co.edu.usbcali.parqueaderoservice.models.Vehiculo;


import java.util.List;

public class VehiculoMapper {

    public static VehiculoDTO domainToDto(Vehiculo vehiculo) {
        VehiculoDTO vehiculoDTO = VehiculoDTO
                .builder()
                .id(vehiculo.getId())
                .placa(vehiculo.getPlaca())
                .build();

        // Verificar si el tipo de vehiculo no es nulo antes de asignar su ID al DTO
        if (vehiculo.getTipoVehiculo() != null) {
            vehiculoDTO.setTipoVehiculo(vehiculo.getTipoVehiculo().getId());
        }

        // Verificar si el usuario no es nulo antes de asignar su ID al DTO
        if (vehiculo.getUsuario() != null) {
            vehiculoDTO.setUsuario(vehiculo.getUsuario().getId());
        }

        return vehiculoDTO;
    }

    public static Vehiculo dtoToDomain(VehiculoDTO vehiculoDTO) throws Exception {

        if (vehiculoDTO.getTipoVehiculo() == null) {
            throw new Exception("Debe proporcionar un tipo de vehiculo válido");
        }

        if (vehiculoDTO.getUsuario() == null) {
            throw new Exception("Debe proporcionar un usuario válido");
        }
        // Crear una instancia de Parqueadero
        Vehiculo vehiculo = Vehiculo.builder()
                .id(vehiculoDTO.getId())
                .placa(vehiculoDTO.getPlaca())
                .build();

        // Crear una instancia de tipo de vehículo y de usuario
        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        tipoVehiculo.setId(vehiculoDTO.getTipoVehiculo());
        vehiculo.setTipoVehiculo(tipoVehiculo);

        Usuario usuario = new Usuario();
        usuario.setId(vehiculoDTO.getUsuario());
        vehiculo.setUsuario(usuario);

        return vehiculo;


    }

    public static List<VehiculoDTO> domainToDtoList (List<Vehiculo> vehiculos){
        return vehiculos.stream().map(VehiculoMapper::domainToDto).toList();
    }


    public static List<Vehiculo> dtoToDomainList(List<VehiculoDTO> vehiculoDTOS) {
        return vehiculoDTOS.stream()
                .map(vehiculoDTO -> {
                    try {
                        return VehiculoMapper.dtoToDomain(vehiculoDTO);
                    } catch (Exception e) {
                        return null;
                    }
                })
                .toList();
    }
}
