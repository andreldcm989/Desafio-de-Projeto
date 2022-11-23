package com.seazonechallenge.desafio.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(int id) {
        super("Não existe registro com o id " + id + ". Verifique e tente novamente.");
    }

}
