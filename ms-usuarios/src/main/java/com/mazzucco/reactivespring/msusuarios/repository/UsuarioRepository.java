package com.mazzucco.reactivespring.msusuarios.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.mazzucco.reactivespring.msusuarios.repository.entity.Usuario;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, String> {

}
