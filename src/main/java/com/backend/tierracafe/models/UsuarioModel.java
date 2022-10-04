package com.backend.tierracafe.models;
import javax.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;

    @Column(length = 100, nullable = false)
    private String TipoDocumento;

    @Column(unique = true)
    private Integer NumeroDocumento;

    private String Nombre;
    @Column(length = 100)
    private String Telefono;
    @Column(length = 100)
    private String Ciudad;

    @Column(unique = true)
    private String Email;

    private String Observacion;
    
}
