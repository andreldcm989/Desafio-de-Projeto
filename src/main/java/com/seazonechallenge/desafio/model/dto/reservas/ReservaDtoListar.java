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

    public ReservaDtoListar() {
    }

    public ReservaDtoListar(Reserva reserva) {
        this.codigo = reserva.getCodigo();
        this.idAnuncio = reserva.getAnuncio().getCodigo();
        this.checkIn = reserva.getCheckIn().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.checkOut = reserva.getCheckOut().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.valorTotal = reserva.getValorTotal();
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

}
