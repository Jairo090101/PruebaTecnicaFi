package jh.proyecto.mappers;


import org.mapstruct.Mapper;

import jh.proyecto.dto.UserCreateDto;
import jh.proyecto.dto.UserDto;
import jh.proyecto.entities.User;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
UserDto toDTO(User usuario);
    User toEntity(UserCreateDto dto);
}
