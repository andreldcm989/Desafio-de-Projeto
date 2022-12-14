package com.seazonechallenge.desafio.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seazonechallenge.desafio.model.dto.reservas.ReservaDtoListar;
import com.seazonechallenge.desafio.model.dto.reservas.ReservaDtoSalvar;
import com.seazonechallenge.desafio.service.ReservaService;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<ReservaDtoListar>> listarReservas() {
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.listarReservas());
    }

    @GetMapping("/{idReserva}")
    public ResponseEntity<ReservaDtoListar> buscarReservaPorId(@PathVariable int idReserva) {
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.buscarReservaPorId(idReserva));
    }

    @PostMapping
    public ResponseEntity<Object> salvarReserva(@RequestBody ReservaDtoSalvar reserva) {
        LocalDate checkIn = LocalDate.parse(reserva.getCheckIn(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate checkOut = LocalDate.parse(reserva.getCheckOut(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (checkOut.isAfter(checkIn)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.salvarReserva(reserva));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A data de check-in deve ser menor que a data de check-out!");
        }
    }

    @PutMapping("/{idReserva}")
    public ResponseEntity<Object> editarReserva(@PathVariable int idReserva, @RequestBody ReservaDtoSalvar reserva) {
        LocalDate checkIn = LocalDate.parse(reserva.getCheckIn(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate checkOut = LocalDate.parse(reserva.getCheckOut(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (checkOut.isAfter(checkIn)) {
            return ResponseEntity.status(HttpStatus.OK).body(reservaService.editarReserva(idReserva, reserva));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A data de check-in deve ser menor que a data de check-out!");
        }
    }

    @DeleteMapping("/{idReserva}")
    public ResponseEntity<Object> excluirReserva(@PathVariable int idReserva) {
        String retorno = (String) reservaService.excluirReserva(idReserva);
        if (retorno.contains("Reserva excluida")) {
            return ResponseEntity.status(HttpStatus.OK).body(retorno);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retorno);
        }
    }
}
