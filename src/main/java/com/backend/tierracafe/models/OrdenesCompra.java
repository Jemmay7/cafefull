package com.backend.tierracafe.models;

import java.sql.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="OrdenesCompras")
public class OrdenesCompra {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;

    
    private Date FechaCompra;

    @ManyToOne
    private UsuarioModel Usuarios;

    @ManyToOne
    private ProductoModel Productos;

}
