package com.seazonechallenge.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seazonechallenge.desafio.model.Imovel;
import com.seazonechallenge.desafio.repository.ImovelRepository;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {

    @Autowired
    private ImovelRepository imovelRepository;

    @GetMapping
    public ResponseEntity<List<Imovel>> listarImoveis() {
        return ResponseEntity.status(HttpStatus.OK).body(imovelRepository.findAll());
    }
}
