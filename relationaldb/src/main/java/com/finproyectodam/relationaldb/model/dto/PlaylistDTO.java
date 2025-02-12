package com.finproyectodam.relationaldb.model.dto;

import com.finproyectodam.relationaldb.model.entitys.Cancion;
import com.finproyectodam.relationaldb.model.entitys.Usuario;


import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase dto de playlist
 * @author cristian && Joel
 * version 1.0
 */
public class PlaylistDTO {

    //atributos de la clase
    private Integer id;
    private String titulo;
    private LocalDate fechacre;
    private String descrip;
    private Usuario userid;
    private Set<Cancion> canciones = new LinkedHashSet<>();

    public PlaylistDTO() {
    }

    /**
     * Constructores de la clase
     * @param id el id de la playlist
     * @param titulo el titulo de la playlist
     * @param fechacre la fecha de creacion de la playlist
     * @param descrip la descripcion de la playlist
     * @param userid el usuario al que pertenece la playlist
     * @param canciones las canciones de la playlist
     */
    public PlaylistDTO(Integer id, String titulo, LocalDate fechacre, String descrip, Usuario userid, Set<Cancion> canciones) {
        this.id = id;
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
        this.userid = userid;
        this.canciones = canciones;
    }

    public PlaylistDTO(String titulo, LocalDate fechacre, String descrip, Usuario userid, Set<Cancion> canciones) {
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
        this.userid = userid;
        this.canciones = canciones;
    }

    public PlaylistDTO(String titulo, LocalDate fechacre, String descrip, Usuario userid) {
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
        this.userid = userid;
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

    public LocalDate getFechacre() {
        return fechacre;
    }

    public void setFechacre(LocalDate fechacre) {
        this.fechacre = fechacre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Usuario getUserid() {
        return userid;
    }

    public void setUserid(Usuario userid) {
        this.userid = userid;
    }

    public Set<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<Cancion> canciones) {
        this.canciones = canciones;
    }

}