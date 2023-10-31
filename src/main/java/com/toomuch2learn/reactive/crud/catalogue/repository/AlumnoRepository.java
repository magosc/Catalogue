package com.toomuch2learn.reactive.crud.catalogue.repository;

import com.toomuch2learn.reactive.crud.catalogue.model.Alumno;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface AlumnoRepository extends ReactiveSortingRepository<Alumno, Long> {

    Flux<Alumno> findByEstado(Integer estado);
}
