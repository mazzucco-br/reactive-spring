package com.mazzucco.reactivespring.msusuarios.api.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mazzucco.reactivespring.msusuarios.client.msTwo.ResponseTwo;

import lombok.Data;

@Data
public class ResponseOne {
    @JsonProperty(required = true)
    public String result;

    @JsonProperty(required = false)
    public String host;

    @JsonProperty(required = false)
    public int port;

    @JsonProperty(required = true)
    public String serviceId;

    @JsonProperty(required = true)
    public ResponseTwo responseTwo;
}