package com.mazzucco.reactivespring.mscontratos.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.mazzucco.reactivespring.mscontratos.repository.entity.Contrato;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ContratoRepository extends ReactiveCrudRepository<Contrato, String> {
}