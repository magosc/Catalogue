package com.toomuch2learn.reactive.crud.alumno;

import com.toomuch2learn.reactive.crud.catalogue.model.Alumno;

import java.time.Instant;

public class AlumnoGenerator {

    private static Instant now = Instant.now();

    public static Alumno generateAlumno(){ return generateAlumno(1000l);}

    public static Alumno generateAlumno(Long id){
        Alumno item = new Alumno();
        item.setId(id);
        item.setNombre("Pepito");
        item.setApellidos("Perez");
        item.setEstado(1);
        item.setEdad(30);

        return item;
    }
}
