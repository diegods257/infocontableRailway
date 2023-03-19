package com.infocontable.infocontable.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.infocontable.infocontable.config.Rol;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {


    @Id
    @Column(nullable = false)
    private String nit;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String empresa;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ReporteContable> reportesContables;

    @Column
    @Enumerated(EnumType.STRING)
    private Rol rol;


    public User(String nit, String contrasena, String nombre, String apellido, String empresa, Rol rol) {
        this.nit = nit;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.empresa = empresa;
        this.rol = rol;
    }
}
