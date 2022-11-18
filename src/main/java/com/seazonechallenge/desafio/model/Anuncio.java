package com.seazonechallenge.desafio.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_anuncios")
public class Anuncio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    @JsonIgnore
    private Imovel imovel;
    private String nomePlataforma;
    private double taxaPlataforma;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    @OneToMany(mappedBy = "anuncio", cascade = CascadeType.REMOVE)
    private List<Reserva> reservas = new ArrayList<>();

    public Anuncio() {
    }

    public Anuncio(Imovel imovel, String nomePlataforma, double taxaPlataforma) {
        this.imovel = imovel;
        this.nomePlataforma = nomePlataforma;
        this.taxaPlataforma = taxaPlataforma;
        this.criadoEm = LocalDateTime.now();
    }

    public int getCodigo() {
        return codigo;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public String getNomePlataforma() {
        return nomePlataforma;
    }

    public void setNomePlataforma(String nomePlataforma) {
        this.nomePlataforma = nomePlataforma;
    }

    public double getTaxaPlataforma() {
        return taxaPlataforma;
    }

    public void setTaxaPlataforma(double taxaPlataforma) {
        this.taxaPlataforma = taxaPlataforma;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

}
