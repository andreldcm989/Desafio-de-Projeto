package com.seazonechallenge.desafio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.seazonechallenge.desafio.model.dto.reservas.ReservaDtoSalvar;

@Entity
@Table(name = "tb_reservas")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @ManyToOne
    @JoinColumn(name = "cod_anuncio")
    private Anuncio anuncio;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double valorTotal;

    @Column(length = 255)
    private String comentarios;
    private int hospedes;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Reserva() {
    }

    public Reserva(Anuncio anuncio, LocalDate checkIn, LocalDate checkOut, double valorTotal, String comentarios,
            int hospedes) {
        this.anuncio = anuncio;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.valorTotal = valorTotal;
        this.comentarios = comentarios;
        this.hospedes = hospedes;
        this.criadoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
    }

    public Reserva(Anuncio anuncio, ReservaDtoSalvar dto) {
        this.anuncio = anuncio;
        this.checkIn = LocalDate.parse(dto.getCheckIn(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.checkOut = LocalDate.parse(dto.getCheckOut(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.valorTotal = dto.getValorTotal();
        this.comentarios = dto.getComentarios();
        this.hospedes = dto.getHospedes();
        this.criadoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
    }

    public int getCodigo() {
        return codigo;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getHospedes() {
        return hospedes;
    }

    public void setHospedes(int hospedes) {
        this.hospedes = hospedes;
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
