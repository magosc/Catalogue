package com.toomuch2learn.reactive.crud.alumno.controller;

import com.toomuch2learn.reactive.crud.alumno.AlumnoGenerator;
import com.toomuch2learn.reactive.crud.catalogue.SpringReactiveCrudCatalogueApplication;
import com.toomuch2learn.reactive.crud.catalogue.model.Alumno;
import com.toomuch2learn.reactive.crud.catalogue.service.AlumnoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@Slf4j
@SpringBootTest(
        classes = SpringReactiveCrudCatalogueApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlumnoControllerTest {

    private static WebTestClient client;

    @LocalServerPort
    int port;

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    public void setApplicationContext(ApplicationContext context) {
        this.client
                = WebTestClient
                .bindToApplicationContext(context)
                .configureClient()
                .baseUrl("/")
                .build();
    }

    @Test
    @Order(10)
    public void testCrearAlumno(){
        Alumno item = AlumnoGenerator.generateAlumno();
        item.setId(null);

        this.client
                .post()
                .uri("/alumnos")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(item), Alumno.class)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);
    }

    //@Test
    @Order(20)
    public void testObtenerAlumnos(){
        createAlumno();

        this.client
                .get()
                .uri("/alumnos")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.[0].ID").isNotEmpty()
                .jsonPath("$.[0].nombre").isNotEmpty()
                .jsonPath("$.[0].apellidos").isNotEmpty()
                .jsonPath("$.[0].estado").isNotEmpty()
                .jsonPath("$.[0].edad").isNotEmpty();
    }

    private void createAlumno(){
        Alumno alumno = AlumnoGenerator.generateAlumno();
        //alumno.setId(null);

        this.client
                .post()
                .uri("/alumnos")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(alumno), Alumno.class)
                .exchange()
                .expectStatus().isCreated();
    }
}
