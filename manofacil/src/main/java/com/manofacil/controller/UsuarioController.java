package com.manofacil.controller;

import com.manofacil.dto.UsuarioRequestDTO;
import com.manofacil.dto.UsuarioResponseDTO;
import com.manofacil.entity.Usuario;
import com.manofacil.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario registrar(@RequestBody UsuarioRequestDTO dto) {
        return usuarioService.registrarUsuario(dto);
    }
    @GetMapping
    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

}
