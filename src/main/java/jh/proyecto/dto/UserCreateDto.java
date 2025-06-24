package jh.proyecto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jh.proyecto.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {

    @NotBlank
    private String nombre;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private Rol rol;

}
