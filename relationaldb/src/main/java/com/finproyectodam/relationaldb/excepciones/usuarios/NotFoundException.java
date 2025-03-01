package com.finproyectodam.relationaldb.excepciones.usuarios;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
