package com.finproyectodam.relationaldb.excepciones.playlist;

/**
 * Excepcion de no encontrar playlist por id
 * @author cristian && Joel
 * @version 1.0
 */
public class IdExcepction extends RuntimeException {
    public IdExcepction(String message) {
        super(message);
    }
}
