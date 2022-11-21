package com.seazonechallenge.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seazonechallenge.desafio.model.Anuncio;
import com.seazonechallenge.desafio.model.dto.anuncios.AnuncioDtoListar;
import com.seazonechallenge.desafio.model.dto.anuncios.AnuncioDtoSalvar;
import com.seazonechallenge.desafio.service.AnuncioService;

@RestController
@RequestMapping("api/anuncios")
public class AnuncioController {

    @Autowired
    private AnuncioService anuncioService;

    @GetMapping
    public ResponseEntity<List<AnuncioDtoListar>> listarAnuncios() {
        return ResponseEntity.ok().body(anuncioService.listarAnuncios());
    }

    @GetMapping("/{idAnuncio}")
    public ResponseEntity<AnuncioDtoListar> buscarAnuncioPorId(@PathVariable int idAnuncio) {
        return ResponseEntity.ok().body(anuncioService.buscarAnuncioPorId(idAnuncio));
    }

    @PostMapping
    public ResponseEntity<AnuncioDtoListar> salvarAnuncio(@RequestBody AnuncioDtoSalvar anuncio) {
        return ResponseEntity.ok().body(anuncioService.salvarAnuncio(anuncio));
    }

    @PutMapping("/{idAnuncio}")
    public ResponseEntity<Anuncio> editarAnuncio(@PathVariable int idAnuncio, @RequestBody Anuncio anuncio) {
        return ResponseEntity.ok().body(anuncioService.editarAnuncio(idAnuncio, anuncio));
    }
}
