package com.finproyectodam.relationaldb.excepciones.usuarios;

/**
 * Clase con la excepcion del registro de usuarios
 * @author cristian && Joel
 * @version 1.0
 */
public class RegistroException extends RuntimeException {
    public RegistroException(String message) {
        super(message);
    }
}
