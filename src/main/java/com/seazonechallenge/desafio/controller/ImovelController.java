package com.seazonechallenge.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seazonechallenge.desafio.model.dto.imoveis.ImovelDtoListar;
import com.seazonechallenge.desafio.model.dto.imoveis.ImovelDtoSalvar;
import com.seazonechallenge.desafio.service.ImovelService;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @GetMapping
    public ResponseEntity<List<ImovelDtoListar>> listarImoveis() {
        return ResponseEntity.status(HttpStatus.OK).body(imovelService.listarImoveis());
    }

    @GetMapping("/{idImovel}")
    public ResponseEntity<ImovelDtoListar> buscarImovelPorId(@PathVariable int idImovel) {
        return ResponseEntity.ok().body(imovelService.buscarImovelPorId(idImovel));
    }

    @PostMapping
    public ResponseEntity<ImovelDtoListar> salvarImovel(@RequestBody ImovelDtoSalvar novoImovel) {
        return ResponseEntity.ok().body(imovelService.salvarImovel(novoImovel));
    }

    @PutMapping("/{idImovel}")
    public ResponseEntity<Object> editarImovel(@PathVariable int idImovel, @RequestBody ImovelDtoSalvar imovel) {
        return ResponseEntity.ok().body(imovelService.editarImovel(idImovel, imovel));
    }

    @DeleteMapping("/{idImovel}")
    public ResponseEntity<HttpStatus> excluirImovelPorId(@PathVariable int idImovel) {
        return imovelService.excluirImovel(idImovel);
    }
}
