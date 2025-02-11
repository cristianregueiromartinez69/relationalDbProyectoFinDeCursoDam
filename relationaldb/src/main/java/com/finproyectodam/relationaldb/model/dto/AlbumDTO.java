package com.finproyectodam.relationaldb.model.dto;

import com.finproyectodam.relationaldb.model.entitys.Artista;
import com.finproyectodam.relationaldb.model.entitys.Cancion;


import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase dto de albumes de los artistas
 * @author cristian && Joel
 * version 1.0
 */
public class AlbumDTO {

    //variables de la clase
    private Integer id;
    private String titulo;
    private Integer anolanz;
    private Artista artistaid;
    private Set<Cancion> canciones = new LinkedHashSet<>();

    /**
     * constructores de la clase
     * @param id el id del album
     * @param titulo el titulo del album
     * @param anolanz el año de lanzamiento del album
     * @param artistaid el artista del cual es el album
     * @param canciones las camciones del album
     */
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