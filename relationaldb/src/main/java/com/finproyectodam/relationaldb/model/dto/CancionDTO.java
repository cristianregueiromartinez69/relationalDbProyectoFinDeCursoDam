package com.finproyectodam.relationaldb.model.dto;

import com.finproyectodam.relationaldb.model.entitys.Album;
import com.finproyectodam.relationaldb.model.entitys.Artista;
import com.finproyectodam.relationaldb.model.entitys.Playlist;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase dto de canciones de los artistas
 * @author cristian && Joel
 * version 1.0
 */
public class CancionDTO {

    //atributos de la clase
    private Integer id;
    private String titulo;
    private Integer duracion;
    private String urlcancion;
    private Artista artistaid;
    private Album albumid;
    private Set<Playlist> playlists = new LinkedHashSet<>();

    public CancionDTO() {
    }

    /**
     * Constructores de la clase
     * @param id el id de la cancion
     * @param titulo el titulo de la cancion
     * @param duracion la duracion de la cancion
     * @param urlcancion la url de la cancion
     * @param artistaid el artista de la cancion
     * @param albumid el album al que pertenece la cancion
     * @param playlists la playlist a la que pertenece la cancion
     */
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

    /**
     * getter y setter de la clase
     * @return los atributos correspondientes
     */
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