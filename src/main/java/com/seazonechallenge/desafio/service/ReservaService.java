package com.seazonechallenge.desafio.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seazonechallenge.desafio.model.Reserva;
import com.seazonechallenge.desafio.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Reserva buscarReservaPorId(int idReserva) {
        return reservaRepository.findById(idReserva)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada."));
    }

    public Reserva salvarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva editarReserva(int idReserva, Reserva reservaEdit) {
        Reserva reserva = reservaRepository.getReferenceById(idReserva);
        reserva.setAnuncio(reservaEdit.getAnuncio());
        reserva.setHospedes(reservaEdit.getHospedes());
        reserva.setCheckIn(reservaEdit.getCheckIn());
        reserva.setCheckOut(reservaEdit.getCheckOut());
        reserva.setComentarios(reservaEdit.getComentarios());
        reserva.setValorTotal(reservaEdit.getValorTotal());
        reserva.setAtualizadoEm();
        return reservaRepository.save(reserva);
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
