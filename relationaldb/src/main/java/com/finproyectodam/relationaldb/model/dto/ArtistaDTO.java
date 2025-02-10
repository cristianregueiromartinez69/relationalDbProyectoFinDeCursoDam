package com.finproyectodam.relationaldb.model.dto;

import com.finproyectodam.relationaldb.model.entitys.Album;
import com.finproyectodam.relationaldb.model.entitys.Cancion;


import java.util.LinkedHashSet;
import java.util.Set;


public class ArtistaDTO {

    private Integer id;


    private String nameart;


    private String generoMusc;


    private String descrip;

    private Set<Album> albumes = new LinkedHashSet<>();

    private Set<Cancion> canciones = new LinkedHashSet<>();

    public ArtistaDTO(Integer id, String nameart, String generoMusc, String descrip, Set<Album> albumes, Set<Cancion> canciones) {
        this.id = id;
        this.nameart = nameart;
        this.generoMusc = generoMusc;
        this.descrip = descrip;
        this.albumes = albumes;
        this.canciones = canciones;
    }

    public ArtistaDTO(String nameart, String generoMusc, String descrip) {
        this.nameart = nameart;
        this.generoMusc = generoMusc;
        this.descrip = descrip;
    }

    public ArtistaDTO(String nameart, String generoMusc, String descrip, Set<Album> albumes, Set<Cancion> canciones) {
        this.nameart = nameart;
        this.generoMusc = generoMusc;
        this.descrip = descrip;
        this.albumes = albumes;
        this.canciones = canciones;
    }

    public ArtistaDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameart() {
        return nameart;
    }

    public void setNameart(String nameart) {
        this.nameart = nameart;
    }

    public String getGeneroMusc() {
        return generoMusc;
    }

    public void setGeneroMusc(String generoMusc) {
        this.generoMusc = generoMusc;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Set<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(Set<Album> albumes) {
        this.albumes = albumes;
    }

    public Set<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<Cancion> canciones) {
        this.canciones = canciones;
    }

}