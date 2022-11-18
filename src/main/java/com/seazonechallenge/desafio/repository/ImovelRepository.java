package com.seazonechallenge.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seazonechallenge.desafio.model.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Integer> {

}
