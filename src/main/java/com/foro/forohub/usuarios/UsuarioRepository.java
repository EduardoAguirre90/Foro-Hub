package com.foro.forohub.usuarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    UserDetails findByLogin(String username);

    //UserDetails findByUsername(String username);
}
