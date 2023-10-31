package com.toomuch2learn.reactive.crud.catalogue.controller;

import com.toomuch2learn.reactive.crud.catalogue.model.ResourceIdentity;
import com.toomuch2learn.reactive.crud.catalogue.model.TraceMsg;
import com.toomuch2learn.reactive.crud.catalogue.service.TraceMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class TraceController {

    @Autowired
    TraceMsgService service;

    @PostMapping("/insertTrace")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<ResponseEntity> createTrace(@RequestBody TraceMsg traceMsg){
        Mono<Long> id = service.createTrace(traceMsg);

        return id.map(value -> ResponseEntity.status(HttpStatus.CREATED).body(new ResourceIdentity(value))).cast(ResponseEntity.class);
    }
    @GetMapping("/getTrace")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<TraceMsg> getTrace(@RequestBody DateRangeRequest request){
        return service.getTrace(request);
    }
}
