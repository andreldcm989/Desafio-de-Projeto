package com.seazonechallenge.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seazonechallenge.desafio.model.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {

}
