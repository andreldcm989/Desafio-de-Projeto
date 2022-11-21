package com.seazonechallenge.desafio.model.dto.imoveis;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import com.seazonechallenge.desafio.model.Imovel;

public class ImovelDtoListar implements Serializable {

    private int idImovel;
    private int limiteHospedes;
    private int banheiros;
    private boolean petFriendly;
    private double valorLimpeza;
    private String dataAtivacao;
    private String criadoEm;
    private String atualizadoEm;

    public ImovelDtoListar() {
    }

    public ImovelDtoListar(Imovel imovel) {
        idImovel = imovel.getIdImovel();
        limiteHospedes = imovel.getLimiteHospedes();
        banheiros = imovel.getBanheiros();
        petFriendly = imovel.isPetFriendly();
        valorLimpeza = imovel.getValorLimpeza();
        dataAtivacao = imovel.getDataAtivacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        criadoEm = imovel.getCriadoEm().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        atualizadoEm = imovel.getAtualizadoEm().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public int getIdImovel() {
        return idImovel;
    }

    public int getLimiteHospedes() {
        return limiteHospedes;
    }

    public int getBanheiros() {
        return banheiros;
    }

    public boolean isPetFriendly() {
        return petFriendly;
    }

    public double getValorLimpeza() {
        return valorLimpeza;
    }

    public String getDataAtivacao() {
        return dataAtivacao;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public String getAtualizadoEm() {
        return atualizadoEm;
    }
}
