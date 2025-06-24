package jh.proyecto.services;

import java.util.List;
import java.util.Optional;

import jh.proyecto.dto.UserCreateDto;
import jh.proyecto.dto.UserDto;

public interface UserService {

    List<UserDto> listarUsuarios();
    Optional<UserDto> obtenerUsuario(Long id);
    UserDto crearUsuario(UserCreateDto dto);
    UserDto actualizarUsuario(Long id, UserCreateDto dto);
    void eliminarUsuario(Long id);
}
