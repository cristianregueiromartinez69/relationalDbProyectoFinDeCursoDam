package com.finproyectodam.relationaldb.model.dto;

import com.finproyectodam.relationaldb.model.entitys.Artista;
import com.finproyectodam.relationaldb.model.entitys.Cancion;


import java.util.LinkedHashSet;
import java.util.Set;


public class AlbumDTO {


    private Integer id;


    private String titulo;


    private Integer anolanz;


    private Artista artistaid;

    private Set<Cancion> canciones = new LinkedHashSet<>();

    public AlbumDTO(Integer id, String titulo, Integer anolanz, Artista artistaid, Set<Cancion> canciones) {
        this.id = id;
        this.titulo = titulo;
        this.anolanz = anolanz;
        this.artistaid = artistaid;
        this.canciones = canciones;
    }

    public AlbumDTO(String titulo, Integer anolanz, Artista artistaid) {
        this.titulo = titulo;
        this.anolanz = anolanz;
        this.artistaid = artistaid;
    }

    public AlbumDTO(String titulo, Integer anolanz, Artista artistaid, Set<Cancion> canciones) {
        this.titulo = titulo;
        this.anolanz = anolanz;
        this.artistaid = artistaid;
        this.canciones = canciones;
    }

    public AlbumDTO() {

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

    public Integer getAnolanz() {
        return anolanz;
    }

    public void setAnolanz(Integer anolanz) {
        this.anolanz = anolanz;
    }

    public Artista getArtistaid() {
        return artistaid;
    }

    public void setArtistaid(Artista artistaid) {
        this.artistaid = artistaid;
    }

    public Set<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<Cancion> canciones) {
        this.canciones = canciones;
    }

}