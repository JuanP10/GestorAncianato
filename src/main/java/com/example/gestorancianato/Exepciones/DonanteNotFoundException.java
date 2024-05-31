package com.example.gestorancianato.Exepciones;

public class DonanteNotFoundException extends RuntimeException {
    public DonanteNotFoundException(String message) {
        super(message);
    }
}
