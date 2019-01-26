package com.mazzucco.reactivespring.mscontratos.api.list;

import java.time.LocalDateTime;

import com.mazzucco.reactivespring.mscommons.api.common.Payload;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ContratoListResponse implements Payload {
    String id;
    LocalDateTime data;
    String descricao;
}
