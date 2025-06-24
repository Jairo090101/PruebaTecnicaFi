package jh.proyecto.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jh.proyecto.dto.UserCreateDto;
import jh.proyecto.dto.UserDto;
import jh.proyecto.entities.User;
import jh.proyecto.mappers.UsuarioMapper;
import jh.proyecto.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

     @Autowired
     private UserRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    //ListarUsuarios
    @Override
    public List<UserDto> listarUsuarios() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    //Obtener Usuario por ID
    @Override
    public Optional<UserDto> obtenerUsuario(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO); // convierte Usuario a UserDto si lo encuentra
    }

    //Crear Nuevo Usuario
    @Override
    public UserDto crearUsuario(UserCreateDto dto) {
       if (repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email ya registrado");
        }
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }
    

    //Actualizar Usuario por Id
    @Override
    public UserDto actualizarUsuario(Long id, UserCreateDto dto) {
        User usuario = repository.findById(id).orElseThrow();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setRol(dto.getRol());
        return mapper.toDTO(repository.save(usuario));
    }

    //Eliminar Usuario por ID
    @Override
    public void eliminarUsuario(Long id) {
                repository.deleteById(id);

    }

}
