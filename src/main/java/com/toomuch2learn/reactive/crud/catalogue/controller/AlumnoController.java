package com.toomuch2learn.reactive.crud.catalogue.controller;

import com.toomuch2learn.reactive.crud.catalogue.model.Alumno;
import com.toomuch2learn.reactive.crud.catalogue.model.ResourceIdentity;
import com.toomuch2learn.reactive.crud.catalogue.service.AlumnoService;
import com.toomuch2learn.reactive.crud.catalogue.service.FibonacciService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RestController

public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @Autowired
    private FibonacciService fservice;

    @PostMapping("/alumnos")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<ResponseEntity> crearAlumno(@Valid @RequestBody Alumno alumno){
        Mono<Long> id = service.crearAlumno(alumno);

        return id.map(value -> ResponseEntity.status(HttpStatus.CREATED).body(new ResourceIdentity(value))).cast(ResponseEntity.class);
    }

    @GetMapping("/alumnos")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Alumno> obtenerAlumnos(){
        return service.obtenerAlumnosActivos();
    }

    @GetMapping("/fibonacci")
    public String fibonacci(@RequestParam(name = "posicion") String posicion){
        return fservice.fibonacci(posicion);
    }
}
