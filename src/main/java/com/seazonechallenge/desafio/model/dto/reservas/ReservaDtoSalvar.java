package com.seazonechallenge.desafio.model.dto.reservas;

import java.io.Serializable;

public class ReservaDtoSalvar implements Serializable {

    private int idAnuncio;
    private String checkIn;
    private String checkOut;
    private double valorTotal;
    private String comentarios;
    private int hospedes;

    public ReservaDtoSalvar() {
    }

    public ReservaDtoSalvar(int idAnuncio, String checkIn, String checkOut, double valorTotal, String comentarios,
            int hospedes) {
        this.idAnuncio = idAnuncio;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.valorTotal = valorTotal;
        this.comentarios = comentarios;
        this.hospedes = hospedes;
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

}
