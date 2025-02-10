package com.finproyectodam.relationaldb.model.dto;


import com.finproyectodam.relationaldb.model.entitys.Cancion;
import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.model.entitys.PlaylistCancionId;

public class PlaylistCancionDTO {

    private PlaylistCancionId id;


    private Playlist playlist;

    private Cancion cancion;

    public PlaylistCancionDTO(PlaylistCancionId id, Playlist playlist, Cancion cancion) {
        this.id = id;
        this.playlist = playlist;
        this.cancion = cancion;
    }

    public PlaylistCancionDTO() {

    }


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