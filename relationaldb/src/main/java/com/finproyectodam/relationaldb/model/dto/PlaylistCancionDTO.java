package com.finproyectodam.relationaldb.model.dto;


import com.finproyectodam.relationaldb.model.entitys.Cancion;
import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.model.entitys.PlaylistCancionId;

/**
 * Clase dto de playlist de spotify
 * @author cristian && Joel
 * version 1.0
 */
public class PlaylistCancionDTO {

    //atributos de clase
    private PlaylistCancionId id;
    private Playlist playlist;
    private Cancion cancion;

    /**
     * Constructores de la clase
     * @param id el id de la playlist
     * @param playlist el nombre de la playlist
     * @param cancion la cancion de la playlist
     */
    public PlaylistCancionDTO(PlaylistCancionId id, Playlist playlist, Cancion cancion) {
        this.id = id;
        this.playlist = playlist;
        this.cancion = cancion;
    }

    public PlaylistCancionDTO() {

    }

    /**
     * getter y setter de la clase
     * @return los atributos correspondientes
     */
    public PlaylistCancionId getId() {
        return id;
    }

    public void setId(PlaylistCancionId id) {
        this.id = id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

}