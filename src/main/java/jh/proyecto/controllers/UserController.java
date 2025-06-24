package jh.proyecto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jh.proyecto.dto.UserCreateDto;
import jh.proyecto.dto.UserDto;
import jh.proyecto.services.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userServiceImpl;


	// Constructor para inyectar UserServiceImpl
	public UserController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

    //Listar Todos los Usuarios
    @GetMapping
    public List<UserDto> listarUsuarios() {
        return userServiceImpl.listarUsuarios();
    }

    //Crear Usuario Nuevo
    @PostMapping
    public ResponseEntity<UserDto> crearNuevoUsuario(@Valid @RequestBody UserCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userServiceImpl.crearUsuario(dto));
    }

    //Obtener Usuario por su Id
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> detalle(@PathVariable Long id) {
        Optional<UserDto> optionalUser = userServiceImpl.obtenerUsuario(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    //Actualizar Usuario por su Id
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> actualizar(@PathVariable Long id, @Valid @RequestBody UserCreateDto dto) {
        Optional<UserDto> optionalUser = userServiceImpl.obtenerUsuario(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(userServiceImpl.actualizarUsuario(id, dto));
        }
        return ResponseEntity.notFound().build();
    }

    //Eliminar Usuario por su Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<UserDto> optionalUser = userServiceImpl.obtenerUsuario(id);
        if (optionalUser.isPresent()) {
            userServiceImpl.eliminarUsuario(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
