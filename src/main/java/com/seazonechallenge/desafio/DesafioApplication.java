package com.seazonechallenge.desafio;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seazonechallenge.desafio.model.Anuncio;
import com.seazonechallenge.desafio.model.Imovel;
import com.seazonechallenge.desafio.model.Reserva;
import com.seazonechallenge.desafio.repository.AnuncioRepository;
import com.seazonechallenge.desafio.repository.ImovelRepository;
import com.seazonechallenge.desafio.repository.ReservaRepository;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	@Autowired
	private ImovelRepository imovelRepository;

	@Autowired
	private AnuncioRepository anuncioRepository;

	@Autowired
	private ReservaRepository reservaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Imovel imovel1 = new Imovel(5, 3, true, 180.00);
		Imovel imovel2 = new Imovel(6, 2, false, 2000.00);
		Imovel imovel3 = new Imovel(3, 1, false, 110.00);
		Imovel imovel4 = new Imovel(2, 1, false, 100.00);
		Imovel imovel5 = new Imovel(12, 4, true, 350.00);
		imovelRepository.saveAll(Arrays.asList(imovel1, imovel2, imovel3, imovel4, imovel5));

		Anuncio a1 = new Anuncio(imovel1, "Hurb", 12.5);
		Anuncio a2 = new Anuncio(imovel1, "AirBnb", 18.5);
		Anuncio a3 = new Anuncio(imovel3, "Booking", 15.5);
		Anuncio a4 = new Anuncio(imovel5, "Booking", 15.5);
		anuncioRepository.saveAll(Arrays.asList(a1, a2, a3, a4));

		Reserva r1 = new Reserva(a1, LocalDate.of(2023, 02, 10), LocalDate.of(2022, 02, 20), 3.500, "chegaremos às 17h",
				4);
		Reserva r2 = new Reserva(a3, LocalDate.of(2023, 02, 10), LocalDate.of(2022, 02, 20), 2.500, null,
				2);
		Reserva r3 = new Reserva(a2, LocalDate.of(2023, 02, 22), LocalDate.of(2022, 02, 24), 1.500, null,
				5);
		Reserva r4 = new Reserva(a1, LocalDate.of(2023, 02, 10), LocalDate.of(2022, 02, 20), 3.500,
				"decoração de aniversário de casamento",
				4);
		reservaRepository.saveAll(Arrays.asList(r1, r2, r3, r4));

	}

}
