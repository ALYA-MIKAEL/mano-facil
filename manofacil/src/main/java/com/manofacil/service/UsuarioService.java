package com.manofacil.service;

import com.manofacil.dto.UsuarioRequestDTO;
import com.manofacil.entity.Direccion;
import com.manofacil.entity.Usuario;
import com.manofacil.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContraseña(dto.getContraseña()); // 🔐 Más adelante encriptamos esto

        Direccion direccion = new Direccion();
        direccion.setCalle(dto.getCalle());
        direccion.setCiudad(dto.getCiudad());
        direccion.setDistrito(dto.getDistrito());
        direccion.setReferencia(dto.getReferencia());

        usuario.setDireccion(direccion);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}