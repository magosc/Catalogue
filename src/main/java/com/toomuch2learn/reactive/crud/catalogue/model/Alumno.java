package com.toomuch2learn.reactive.crud.catalogue.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@Table("ALUMNOS")
public class Alumno {

    @Id
    @Column("ID")
    private Long id;
    @NotEmpty(message = "Nombre no puede ser vacio")
    @NonNull
    private String nombre;
    @NotEmpty(message = "Apellidos no puede ser vacio")
    @NonNull
    private String apellidos;
    private Integer estado;
    private Integer edad;
}
