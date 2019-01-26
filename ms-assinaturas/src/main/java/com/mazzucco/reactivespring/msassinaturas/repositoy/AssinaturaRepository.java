package com.mazzucco.reactivespring.msassinaturas.repositoy;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.mazzucco.reactivespring.msassinaturas.repositoy.entity.Assinatura;

@Repository
public interface AssinaturaRepository extends ReactiveCrudRepository<Assinatura, String> {

}
