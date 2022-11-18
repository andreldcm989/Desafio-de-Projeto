package com.seazonechallenge.desafio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/{idImovel}")
    public ResponseEntity<Optional<Imovel>> buscarImovelPorId(@PathVariable int idImovel) {
        return ResponseEntity.ok().body(imovelRepository.findById(idImovel));
    }

    @PutMapping
    public ResponseEntity<Imovel> editarImovel(@RequestParam int idImovel, @RequestBody Imovel imovel) {
        Imovel i = imovelRepository.getReferenceById(idImovel);
        i.setLimiteHospedes(imovel.getLimiteHospedes());
        i.setBanheiros(imovel.getBanheiros());
        i.setPetFriendly(imovel.isPetFriendly());
        i.setValorLimpeza(imovel.getValorLimpeza());
        i.setAtualizadoEm();
        return ResponseEntity.ok().body(imovelRepository.save(i));
    }
}
