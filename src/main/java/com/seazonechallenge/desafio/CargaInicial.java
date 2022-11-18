// package com.seazonechallenge.desafio;

// import java.util.Arrays;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Configuration;

// import com.seazonechallenge.desafio.model.Anuncio;
// import com.seazonechallenge.desafio.model.Imovel;
// import com.seazonechallenge.desafio.repository.AnuncioRepository;
// import com.seazonechallenge.desafio.repository.ImovelRepository;
// import com.seazonechallenge.desafio.repository.ReservaRepository;

// @Configuration
// public class CargaInicial implements CommandLineRunner {

// @Autowired
// private ImovelRepository imovelRepository;

// @Autowired
// private AnuncioRepository anuncioRepository;

// @Autowired
// private ReservaRepository reservaRepository;

// @Override
// public void run(String... args) throws Exception {

// Imovel imovel1 = new Imovel(5, 3, true, 180.00);
// Imovel imovel2 = new Imovel(6, 2, false, 2000.00);
// Imovel imovel3 = new Imovel(3, 1, false, 110.00);
// Imovel imovel4 = new Imovel(2, 1, false, 100.00);
// Imovel imovel5 = new Imovel(12, 4, true, 350.00);

// imovelRepository.saveAll(Arrays.asList(imovel1, imovel2, imovel3, imovel4,
// imovel5));

// }

// }
