package com.mazzucco.reactivespring.msusuarios.api.search;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ErrorResult {
    @JsonProperty(required = true)
    private Integer code;
    @JsonProperty(required = true)
    private String error;
}
