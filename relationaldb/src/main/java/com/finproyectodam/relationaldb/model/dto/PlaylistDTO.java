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


    public PlaylistDTO() {
    }

    /**
     * Constructores de la clase
     * @param id el id de la playlist
     * @param titulo el titulo de la playlist
     * @param fechacre la fecha de creacion de la playlist
     * @param descrip la descripcion de la playlist
     */
    public PlaylistDTO(Integer id, String titulo, LocalDate fechacre, String descrip) {
        this.id = id;
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
    }

    public PlaylistDTO(String titulo, LocalDate fechacre, String descrip) {
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
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



}