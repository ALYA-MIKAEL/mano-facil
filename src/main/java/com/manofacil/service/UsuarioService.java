package com.manofacil.service;

import com.manofacil.dto.UsuarioRequestDTO;
import com.manofacil.dto.UsuarioResponseDTO;
import com.manofacil.entity.Direccion;
import com.manofacil.entity.Usuario;
import com.manofacil.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(UsuarioRequestDTO dto) {

        if (usuarioRepository.existsByCorreo(dto.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        } //CORREO UNICO

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContraseña(dto.getContraseña()); //encriptamos esto

        // Encriptamos la contraseña
        String passwordEncriptada = passwordEncoder.encode(dto.getContraseña());
        usuario.setContraseña(passwordEncriptada);

        Direccion direccion = new Direccion();
        direccion.setCalle(dto.getCalle());
        direccion.setCiudad(dto.getCiudad());
        direccion.setDistrito(dto.getDistrito());
        direccion.setReferencia(dto.getReferencia());

        usuario.setDireccion(direccion);

        return usuarioRepository.save(usuario);
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(usuario -> {
            UsuarioResponseDTO dto = new UsuarioResponseDTO();
            dto.setId(usuario.getId());
            dto.setNombre(usuario.getNombre());
            dto.setCorreo(usuario.getCorreo());
            dto.setDireccion(usuario.getDireccion());
            return dto;
        }).collect(Collectors.toList());
    }
}