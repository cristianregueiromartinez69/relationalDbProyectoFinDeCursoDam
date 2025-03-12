package com.finproyectodam.relationaldb.excepciones.playlist;

/**
 * Excepcion de no encontrar playlist
 * @author cristian && Joel
 * @version 1.0
 */
public class PlaylistNotFoundException extends RuntimeException {
    public PlaylistNotFoundException(String message) {
        super(message);
    }
}
