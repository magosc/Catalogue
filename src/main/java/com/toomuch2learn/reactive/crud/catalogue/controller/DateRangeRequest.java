package com.toomuch2learn.reactive.crud.catalogue.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@NoArgsConstructor
@Getter
@Setter
public class DateRangeRequest {

    @NotNull
    private OffsetDateTime from;

    @NotNull
    private OffsetDateTime to;
}
