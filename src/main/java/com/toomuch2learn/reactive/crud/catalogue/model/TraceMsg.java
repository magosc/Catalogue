package com.toomuch2learn.reactive.crud.catalogue.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@Table("TRACEMSG")
public class TraceMsg {

    @Id
    @Column("ID")
    private Long id;

    private String sessionId;

    private String payload;

    private OffsetDateTime ts;
}
