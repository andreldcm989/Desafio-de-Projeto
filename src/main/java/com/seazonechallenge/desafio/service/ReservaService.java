package com.seazonechallenge.desafio.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seazonechallenge.desafio.model.Reserva;
import com.seazonechallenge.desafio.model.dto.reservas.ReservaDtoListar;
import com.seazonechallenge.desafio.model.dto.reservas.ReservaDtoSalvar;
import com.seazonechallenge.desafio.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private AnuncioService anuncioService;

    public List<ReservaDtoListar> listarReservas() {
        return reservaRepository.findAll().stream().map(ReservaDtoListar::new).toList();
    }

    public ReservaDtoListar buscarReservaPorId(int idReserva) {
        return new ReservaDtoListar(reservaRepository.findById(idReserva)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada.")));
    }

    public ReservaDtoListar salvarReserva(ReservaDtoSalvar dto) {
        Reserva reserva = new Reserva(anuncioService.findById(dto.getIdAnuncio()), dto);
        return new ReservaDtoListar(reservaRepository.save(reserva));
    }

    public ReservaDtoListar editarReserva(int idReserva, ReservaDtoSalvar reservaEdit) {
        Reserva reserva = reservaRepository.getReferenceById(idReserva);
        reserva.setAnuncio(anuncioService.findById(reservaEdit.getIdAnuncio()));
        reserva.setHospedes(reservaEdit.getHospedes());
        reserva.setCheckIn(LocalDate.parse(reservaEdit.getCheckIn(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        reserva.setCheckOut(LocalDate.parse(reservaEdit.getCheckOut(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        reserva.setComentarios(reservaEdit.getComentarios());
        reserva.setValorTotal(reservaEdit.getValorTotal());
        reserva.setAtualizadoEm();
        return new ReservaDtoListar(reservaRepository.save(reserva));
    }

    public Object excluirReserva(int idReserva) {
        if (reservaRepository.existsById(idReserva)) {
            reservaRepository.deleteById(idReserva);
            return "Reserva excluida com sucesso!";
        } else {
            return "Reserva não encontrada!";
        }
    }

}
