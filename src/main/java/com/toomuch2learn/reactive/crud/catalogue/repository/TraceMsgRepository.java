package com.toomuch2learn.reactive.crud.catalogue.repository;

import com.toomuch2learn.reactive.crud.catalogue.model.TraceMsg;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

import java.time.OffsetDateTime;

public interface TraceMsgRepository extends ReactiveSortingRepository<TraceMsg, Long> {

    Flux<TraceMsg> findByRange(OffsetDateTime from, OffsetDateTime to);
}
