package com.seazonechallenge.desafio.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seazonechallenge.desafio.model.Anuncio;
import com.seazonechallenge.desafio.model.dto.anuncios.AnuncioDtoListar;
import com.seazonechallenge.desafio.model.dto.anuncios.AnuncioDtoSalvar;
import com.seazonechallenge.desafio.repository.AnuncioRepository;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private ImovelService imovelService;

    public List<AnuncioDtoListar> listarAnuncios() {
        return anuncioRepository.findAll().stream().map(AnuncioDtoListar::new).toList();
    }

    public AnuncioDtoListar buscarAnuncioPorId(int idAnuncio) {
        Anuncio anuncio = anuncioRepository.findById(idAnuncio)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum Anuncio encontrado com este ID."));
        return new AnuncioDtoListar(anuncio);
    }

    public AnuncioDtoListar salvarAnuncio(AnuncioDtoSalvar dto) {
        Anuncio anuncio = new Anuncio(imovelService.findById(dto.getIdImovel()), dto);
        anuncioRepository.save(anuncio);
        return new AnuncioDtoListar(anuncio);
    }

    public AnuncioDtoListar editarAnuncio(int idAnuncio, AnuncioDtoSalvar anuncioEdit) {
        Anuncio anuncio = anuncioRepository.getReferenceById(idAnuncio);
        anuncio.setImovel(imovelService.findById(anuncioEdit.getIdImovel()));
        anuncio.setNomePlataforma(anuncioEdit.getNomePlataforma());
        anuncio.setTaxaPlataforma(anuncioEdit.getTaxaPlataforma());
        anuncio.setAtualizadoEm();
        anuncioRepository.save(anuncio);
        return new AnuncioDtoListar(anuncio);
    }

}
