package com.finproyectodam.relationaldb.model.dto;

import com.finproyectodam.relationaldb.model.entitys.Album;
import com.finproyectodam.relationaldb.model.entitys.Artista;
import com.finproyectodam.relationaldb.model.entitys.Playlist;

import java.util.LinkedHashSet;
import java.util.Set;

public class CancionDTO {


    private Integer id;

    private String titulo;

    private Integer duracion;


    private String urlcancion;


    private Artista artistaid;

    private Album albumid;


    private Set<Playlist> playlists = new LinkedHashSet<>();

    public CancionDTO() {
    }

    public CancionDTO(Integer id, String titulo, Integer duracion, String urlcancion, Artista artistaid, Album albumid, Set<Playlist> playlists) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.urlcancion = urlcancion;
        this.artistaid = artistaid;
        this.albumid = albumid;
        this.playlists = playlists;
    }

    public CancionDTO(String titulo, Integer duracion, String urlcancion, Artista artistaid, Album albumid) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.urlcancion = urlcancion;
        this.artistaid = artistaid;
        this.albumid = albumid;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getUrlcancion() {
        return urlcancion;
    }

    public void setUrlcancion(String urlcancion) {
        this.urlcancion = urlcancion;
    }

    public Artista getArtistaid() {
        return artistaid;
    }

    public void setArtistaid(Artista artistaid) {
        this.artistaid = artistaid;
    }

    public Album getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Album albumid) {
        this.albumid = albumid;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }

}