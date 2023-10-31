package com.toomuch2learn.reactive.crud.catalogue.service;

import com.toomuch2learn.reactive.crud.catalogue.model.Alumno;
import com.toomuch2learn.reactive.crud.catalogue.repository.AlumnoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    AlumnoService(AlumnoRepository repository){
        this.alumnoRepository = repository;
    }

    public Mono<Long> crearAlumno(Alumno alumno){
        return alumnoRepository
                .save(alumno)
                .flatMap(item -> Mono.just(item.getId()));
    }

    public Flux<Alumno> obtenerAlumnosActivos(){
        return alumnoRepository.findByEstado(1);
    }
}
