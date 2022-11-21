package com.seazonechallenge.desafio.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.seazonechallenge.desafio.model.Imovel;
import com.seazonechallenge.desafio.model.dto.imoveis.ImovelDtoListar;
import com.seazonechallenge.desafio.model.dto.imoveis.ImovelDtoSalvar;
import com.seazonechallenge.desafio.repository.ImovelRepository;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public List<ImovelDtoListar> listarImoveis() {
        return imovelRepository.findAll().stream().map(ImovelDtoListar::new).toList();
    }

    public ImovelDtoListar buscarImovelPorId(int idImovel) {
        Imovel imovel = imovelRepository.findById(idImovel)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum imovel encontrado com o id " + idImovel + "."));
        return new ImovelDtoListar(imovel);
    }

    public Imovel findById(int idImovel) {
        return imovelRepository.findById(idImovel)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum imovel encontrado com o id " + idImovel + "."));
    }

    public ImovelDtoListar salvarImovel(ImovelDtoSalvar novoImovel) {
        Imovel imovel = new Imovel(novoImovel);
        return new ImovelDtoListar(imovelRepository.save(imovel));
    }

    public Object editarImovel(int idImovel, ImovelDtoSalvar imovelEdit) {
        try {
            Imovel imovel = imovelRepository.getReferenceById(idImovel);
            imovel.setLimiteHospedes(imovelEdit.getLimiteHospedes());
            BeanUtils.copyProperties(imovelEdit, imovel);
            imovel.setAtualizadoEm();
            return new ImovelDtoListar(imovelRepository.save(imovel));
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
