package com.backend.tierracafe.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tierracafe.models.ProductoModel;
import com.backend.tierracafe.repositories.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    ProductoRepository productoRepository;

    public ArrayList<ProductoModel>listarProductos()
    {
        return (ArrayList<ProductoModel>)productoRepository.findAll();
    }

    public Optional<ProductoModel>obtenerPorId(Long id)
    {
        return productoRepository.findById(id);
    }

    public ProductoModel guadarProducto(ProductoModel producto)
    {
        return productoRepository.save(producto);
    }
}
