package com.seazonechallenge.desafio.model.dto.reservas;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import com.seazonechallenge.desafio.model.Reserva;

public class ReservaDtoListar implements Serializable {

    private int codigo;
    private int idAnuncio;
    private String checkIn;
    private String checkOut;
    private double valorTotal;
    private String comentarios;
    private int hospedes;
    private String criadoEm;
    private String atualizadoEm;

    public ReservaDtoListar() {
    }

    public ReservaDtoListar(Reserva reserva) {
        this.codigo = reserva.getCodigo();
        this.idAnuncio = reserva.getAnuncio().getCodigo();
        this.checkIn = reserva.getCheckIn().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.checkOut = reserva.getCheckOut().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.valorTotal = reserva.getValorTotal();
        this.comentarios = reserva.getComentarios();
        this.hospedes = reserva.getHospedes();
        this.criadoEm = reserva.getCriadoEm().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.atualizadoEm = reserva.getAtualizadoEm().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public int getCodigo() {
        return codigo;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getComentarios() {
        return comentarios;
    }

    public int getHospedes() {
        return hospedes;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public String getAtualizadoEm() {
        return atualizadoEm;
    }

}
