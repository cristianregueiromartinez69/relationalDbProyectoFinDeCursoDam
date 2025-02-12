package com.finproyectodam.relationaldb.usuarios.login.excepcion;

public class LoginUserExcepcion extends RuntimeException {
    public LoginUserExcepcion(String message) {
        super(message);
    }
}
