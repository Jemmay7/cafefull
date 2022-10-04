package com.backend.tierracafe.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tierracafe.models.UsuarioModel;
import com.backend.tierracafe.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel>listarUsuarios()
    {
        return (ArrayList<UsuarioModel>)usuarioRepository.findAll();
    }

    public Optional<UsuarioModel>obtenerPorId(Long id)
    {
        return usuarioRepository.findById(id);
    }

    /*public Optional<ArrayList<UsuarioModel>>obtenerPorCedula(float Cedula)
    {
        return usuarioRepository.findByCedula(Cedula);
    }

    public Optional<ArrayList<UsuarioModel>>obtenerPorCiudad(String Ciudad)
    {
        return usuarioRepository.findByCiudad(Ciudad);
    }*/

    public UsuarioModel guadarUsuario(UsuarioModel usuario)
    {
        return usuarioRepository.save(usuario);
    }

    public boolean eliminarUsuario(Long id)
    {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
