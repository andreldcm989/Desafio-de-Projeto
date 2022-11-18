package com.seazonechallenge.desafio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_imovel")
public class Imovel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idImovel = 0;
    private int limiteHospedes;
    private int banheiros;
    private boolean petFriendly;
    private double valorLimpeza;
    private LocalDate dataAtivacao;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Imovel() {
    }

    public Imovel(int limiteHospedes, int banheiros, boolean petFriendly, double valorLimpeza, LocalDate dataAtivacao,
            LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.limiteHospedes = limiteHospedes;
        this.banheiros = banheiros;
        this.petFriendly = petFriendly;
        this.valorLimpeza = valorLimpeza;
        this.dataAtivacao = dataAtivacao;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public int getLimiteHospedes() {
        return limiteHospedes;
    }

    public void setLimiteHospedes(int limiteHospedes) {
        this.limiteHospedes = limiteHospedes;
    }

    public int getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(int banheiros) {
        this.banheiros = banheiros;
    }

    public boolean isPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public double getValorLimpeza() {
        return valorLimpeza;
    }

    public void setValorLimpeza(double valorLimpeza) {
        this.valorLimpeza = valorLimpeza;
    }

    public LocalDate getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(LocalDate dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

}
