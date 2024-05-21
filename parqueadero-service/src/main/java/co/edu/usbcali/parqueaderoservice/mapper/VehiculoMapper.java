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
                .tipoVehiculo(vehiculo.getTipoVehiculo().getId())
                .usuario(vehiculo.getUsuario().getId())
                .build();

        return vehiculoDTO;
    }

    public static Vehiculo dtoToDomain(VehiculoDTO vehiculoDTO) throws Exception {

        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        tipoVehiculo.setId(vehiculoDTO.getTipoVehiculo());

        Usuario usuario = new Usuario();
        usuario.setId(vehiculoDTO.getUsuario());

        Vehiculo vehiculo = Vehiculo.builder()
                .id(vehiculoDTO.getId())
                .placa(vehiculoDTO.getPlaca())
                .tipoVehiculo(tipoVehiculo)
                .usuario(usuario)
                .build();

        return vehiculo;
    }

    public static List<VehiculoDTO> domainToDtoList (List<Vehiculo> vehiculos){
        return vehiculos.stream().map(VehiculoMapper::domainToDto).toList();
    }
}
