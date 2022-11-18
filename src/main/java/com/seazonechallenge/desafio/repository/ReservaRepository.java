package com.seazonechallenge.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seazonechallenge.desafio.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}
