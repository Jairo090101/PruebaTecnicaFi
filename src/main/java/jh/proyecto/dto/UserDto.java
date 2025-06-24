package jh.proyecto.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String nombre;
    private String email;
    private String rol;
    private LocalDateTime fechaRegistro;
    
}
