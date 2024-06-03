package com.example.gestorancianato.Exepciones;

import org.springframework.http.HttpStatus;

public class CategoriaMedicamentoNotFoundException extends RuntimeException {

    public CategoriaMedicamentoNotFoundException(String message) {
        super(message);
    }

}
