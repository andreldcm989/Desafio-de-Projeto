package com.seazonechallenge.desafio.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.seazonechallenge.desafio.model.Imovel;
import com.seazonechallenge.desafio.model.dto.imoveis.ImovelDtoListar;
import com.seazonechallenge.desafio.model.dto.imoveis.ImovelDtoSalvar;
import com.seazonechallenge.desafio.repository.ImovelRepository;
import com.seazonechallenge.desafio.service.exceptions.ResourceNotFoundException;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public List<ImovelDtoListar> listarImoveis() {
        return imovelRepository.findAll().stream().map(ImovelDtoListar::new).toList();
    }

    public ImovelDtoListar buscarImovelPorId(int idImovel) {
        Imovel imovel = imovelRepository.findById(idImovel)
                .orElseThrow(() -> new ResourceNotFoundException(idImovel));
        return new ImovelDtoListar(imovel);
    }

    public Imovel findById(int idImovel) {
        return imovelRepository.findById(idImovel)
                .orElseThrow(() -> new ResourceNotFoundException(idImovel));
    }

    public ImovelDtoListar salvarImovel(ImovelDtoSalvar novoImovel) {
        Imovel imovel = new Imovel(novoImovel);
        return new ImovelDtoListar(imovelRepository.save(imovel));
    }

    public ImovelDtoListar editarImovel(int idImovel, ImovelDtoSalvar imovelEdit) {
        try {
            Imovel imovel = imovelRepository.getReferenceById(idImovel);
            imovel.setLimiteHospedes(imovelEdit.getLimiteHospedes());
            BeanUtils.copyProperties(imovelEdit, imovel);
            imovel.setAtualizadoEm();
            return new ImovelDtoListar(imovelRepository.save(imovel));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(idImovel);
        }
    }

    public void excluirImovel(int idImovel) {
        try {
            imovelRepository.deleteById(idImovel);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(idImovel);
        }
    }
}
