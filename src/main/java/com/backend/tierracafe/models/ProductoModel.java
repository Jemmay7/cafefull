package com.backend.tierracafe.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="productos") //Se deja productModel para identificar rapidamente esa clase a que hace alusión
                         //Por ejemplo ProductoController hace alusión a un controlador de producto
                         //ProductModel hace alusión a un Modelo de la tabla producto. etc.
public class ProductoModel {
    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 100)
    private String nombre_producto;


    private String descripcion_producto;


    @Column(precision = 19, scale =2)
    private Number precio;

    @Column(precision = 19, scale =2)
    private Number peso;

    
    private String imagen;


}
