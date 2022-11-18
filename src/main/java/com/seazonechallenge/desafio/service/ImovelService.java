package com.seazonechallenge.desafio.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.seazonechallenge.desafio.model.Imovel;
import com.seazonechallenge.desafio.repository.ImovelRepository;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public List<Imovel> listarImoveis() {
        return imovelRepository.findAll();
    }

    public Imovel buscarImovelPorId(int idImovel) {
        return imovelRepository.findById(idImovel)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum imovel encontrado com o id " + idImovel + "."));
    }

    public Imovel salvarImovel(Imovel novoImovel) {
        Imovel imovel = new Imovel(novoImovel.getLimiteHospedes(), novoImovel.getBanheiros(),
                novoImovel.isPetFriendly(), novoImovel.getValorLimpeza());
        return imovelRepository.save(imovel);
    }

    public Object editarImovel(int idImovel, Imovel imovelEdit) {
        try {
            Imovel imovel = imovelRepository.getReferenceById(idImovel);
            imovel.setLimiteHospedes(imovelEdit.getLimiteHospedes());
            imovel.setBanheiros(imovelEdit.getBanheiros());
            imovel.setPetFriendly(imovelEdit.isPetFriendly());
            imovel.setValorLimpeza(imovelEdit.getValorLimpeza());
            imovel.setAtualizadoEm();
            return imovelRepository.save(imovel);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound();
        }
    }

    public ResponseEntity<HttpStatus> excluirImovel(int idImovel) {
        try {
            imovelRepository.deleteById(idImovel);
            return ResponseEntity.ok().body(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
