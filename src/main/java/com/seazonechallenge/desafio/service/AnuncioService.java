package com.seazonechallenge.desafio.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seazonechallenge.desafio.model.Anuncio;
import com.seazonechallenge.desafio.repository.AnuncioRepository;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    public List<Anuncio> listarAnuncios() {
        return anuncioRepository.findAll();
    }

    public Anuncio buscarAnuncioPorId(int idAnuncio) {
        return anuncioRepository.findById(idAnuncio)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum Anuncio encontrado com este ID."));
    }

    public Anuncio salvarAnuncio(Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }

    public Anuncio editarAnuncio(int idAnuncio, Anuncio anuncioEdit) {
        Anuncio anuncio = anuncioRepository.getReferenceById(idAnuncio);
        anuncio.setImovel(anuncioEdit.getImovel());
        anuncio.setNomePlataforma(anuncioEdit.getNomePlataforma());
        anuncio.setTaxaPlataforma(anuncioEdit.getTaxaPlataforma());
        anuncio.setAtualizadoEm();
        return anuncioRepository.save(anuncio);
    }

}
