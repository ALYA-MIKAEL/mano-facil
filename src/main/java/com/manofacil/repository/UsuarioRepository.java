package com.manofacil.repository;

import com.manofacil.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreo(String correo);  // Buscar usuario por correo (para evitar duplicados)
    boolean existsByCorreo(String correo);

}

