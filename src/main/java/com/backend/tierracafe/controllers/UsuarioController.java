package com.backend.tierracafe.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tierracafe.models.UsuarioModel;
import com.backend.tierracafe.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping
    public ArrayList<UsuarioModel> listarUsuarios() 
    { 
        return usuarioService.listarUsuarios();
    }

    @GetMapping(path="/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id)
    {
        return usuarioService.obtenerPorId(id);
    }

    /*@GetMapping("/bycedula")
    public Optional<ArrayList<UsuarioModel>> obtenerUsuarioPorCedula(@PathVariable("Cedula") float Cedula)
    {
        return usuarioService.obtenerPorCedula(Cedula);
    }

    @GetMapping("/byciudad")
    public Optional<ArrayList<UsuarioModel>> obtenerUsuarioPorCiudad(@PathVariable("Ciudad") String ciudad)
    {
        return usuarioService.obtenerPorCiudad(ciudad);
    }*/

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario)
    {
        return usuarioService.guadarUsuario(usuario);
    }

    
    @DeleteMapping(path="/{id}")
    public String eliminarPorId(@PathVariable("id") Long id)
    {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok)
        {
            return "Se eliminó el usuario con id " + id;
        }
        else
        {
            return "No se pudo eliminar el usuario con id " + id;
        }
    }
}
