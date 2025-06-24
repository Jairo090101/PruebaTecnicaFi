package jh.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jh.proyecto.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    boolean existsByEmail(String email);
}
