package com.seazonechallenge.desafio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_imoveis")
public class Imovel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idImovel;
    private int limiteHospedes;
    private int banheiros;
    private boolean petFriendly;
    private double valorLimpeza;
    private LocalDate dataAtivacao;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    @OneToMany(mappedBy = "imovel", cascade = CascadeType.REMOVE)
    private List<Anuncio> anuncios = new ArrayList<>();

    public Imovel() {
    }

    public Imovel(int limiteHospedes, int banheiros, boolean petFriendly, double valorLimpeza) {
        this.limiteHospedes = limiteHospedes;
        this.banheiros = banheiros;
        this.petFriendly = petFriendly;
        this.valorLimpeza = valorLimpeza;
        this.dataAtivacao = LocalDate.now();
        this.criadoEm = LocalDateTime.now();
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

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm() {
        this.atualizadoEm = LocalDateTime.now();
    }

}
