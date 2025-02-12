package com.finproyectodam.relationaldb.excepciones.usuarios;

/**
 * Clase que registra la excepcion de error de login de usuario
 * @author cristian && Joel
 * @version 1.0
 */
public class LoginUserExcepcion extends RuntimeException {
    public LoginUserExcepcion(String message) {
        super(message);
    }
}
