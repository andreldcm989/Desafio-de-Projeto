package com.seazonechallenge.desafio.model.dto.imoveis;

import java.io.Serializable;

public class ImovelDtoSalvar implements Serializable {

    private int limiteHospedes;
    private int banheiros;
    private boolean petFriendly;
    private double valorLimpeza;

    public ImovelDtoSalvar() {
    }

    public ImovelDtoSalvar(int limiteHospedes, int banheiros, boolean petFriendly, double valorLimpeza, String criadoEm,
            String atualizadoEm) {
        this.limiteHospedes = limiteHospedes;
        this.banheiros = banheiros;
        this.petFriendly = petFriendly;
        this.valorLimpeza = valorLimpeza;
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

}
