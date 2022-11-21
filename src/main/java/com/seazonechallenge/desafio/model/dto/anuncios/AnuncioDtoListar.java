package com.seazonechallenge.desafio.model.dto.anuncios;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import com.seazonechallenge.desafio.model.Anuncio;

public class AnuncioDtoListar implements Serializable {

    private int codigo;
    private int idImovel;
    private String nomePlataforma;
    private double taxaPlataforma;
    private String criadoEm;
    private String atualizadoEm;

    public AnuncioDtoListar() {
    }

    public AnuncioDtoListar(Anuncio anuncio) {
        codigo = anuncio.getCodigo();
        idImovel = anuncio.getImovel().getIdImovel();
        nomePlataforma = anuncio.getNomePlataforma();
        taxaPlataforma = anuncio.getTaxaPlataforma();
        criadoEm = anuncio.getCriadoEm().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        atualizadoEm = anuncio.getAtualizadoEm().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public int getCodigo() {
        return codigo;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public String getNomePlataforma() {
        return nomePlataforma;
    }

    public double getTaxaPlataforma() {
        return taxaPlataforma;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public String getAtualizadoEm() {
        return atualizadoEm;
    }

}
