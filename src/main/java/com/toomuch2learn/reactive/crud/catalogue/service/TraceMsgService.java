package com.toomuch2learn.reactive.crud.catalogue.service;

import com.toomuch2learn.reactive.crud.catalogue.controller.DateRangeRequest;
import com.toomuch2learn.reactive.crud.catalogue.model.TraceMsg;
import com.toomuch2learn.reactive.crud.catalogue.repository.TraceMsgRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TraceMsgService {

    private final TraceMsgRepository repository;

    TraceMsgService(TraceMsgRepository traceMsgRepository){ this.repository = traceMsgRepository; }

    public Mono<Long> createTrace(TraceMsg traceMsg){
        return repository
                .save(traceMsg)
                .flatMap(item -> Mono.just(item.getId()));
    }

    public Flux<TraceMsg> getTrace(DateRangeRequest request){
        return repository.findByRange(request.getFrom(), request.getTo());
    }
}
