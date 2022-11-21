package com.seazonechallenge.desafio.model.dto.anuncios;

import java.io.Serializable;

public class AnuncioDtoSalvar implements Serializable {

    private int idImovel;
    private String nomePlataforma;
    private double taxaPlataforma;

    public AnuncioDtoSalvar() {
    }

    public AnuncioDtoSalvar(int idImovel, String nomePlataforma, double taxaPlataforma) {
        this.idImovel = idImovel;
        this.nomePlataforma = nomePlataforma;
        this.taxaPlataforma = taxaPlataforma;
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

}
