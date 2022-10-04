package com.backend.tierracafe.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tierracafe.models.ProductoModel;
import com.backend.tierracafe.services.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired  
    ProductoService productoService;

    @GetMapping()
    public ArrayList<ProductoModel> obtenerProductos()
    {
        return productoService.listarProductos();
    }

    @PostMapping()
    public ProductoModel guardarUsuario(@RequestBody ProductoModel producto)
    {
        return productoService.guadarProducto(producto);
    }
}
