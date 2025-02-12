package com.finproyectodam.relationaldb.model.dto;

import com.finproyectodam.relationaldb.model.entitys.Playlist;


import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase dto de los usuarios
 * @author cristian && Joel
 * version 1.0
 */
public class UsuarioDTO {

    //atributos de la clase
    private Integer id;
    private String username;
    private String email;
    private String passwordU;
    private LocalDate dateReg;
    private Set<Playlist> playlists = new LinkedHashSet<>();

    public UsuarioDTO() {

    }

    /**
     * constructores de la clase
     * @param id el id del usuario
     * @param username el alias del usuario
     * @param email el email del usuario
     * @param passwordU la contraseña del usuario
     * @param dateReg la fecha de registro del usuario
     * @param playlists las playlist del usuario
     */
    public UsuarioDTO(Integer id, String username, String email, String passwordU, LocalDate dateReg, Set<Playlist> playlists) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordU = passwordU;
        this.dateReg = dateReg;
        this.playlists = playlists;
    }

    public UsuarioDTO(String username, String email, String passwordU, LocalDate dateReg, Set<Playlist> playlists) {
        this.username = username;
        this.email = email;
        this.passwordU = passwordU;
        this.dateReg = dateReg;
        this.playlists = playlists;
    }

    public UsuarioDTO(String username, String email, String passwordU, LocalDate dateReg) {
        this.username = username;
        this.email = email;
        this.passwordU = passwordU;
        this.dateReg = dateReg;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordU() {
        return passwordU;
    }

    public void setPasswordU(String passwordU) {
        this.passwordU = passwordU;
    }

    public LocalDate getDateReg() {
        return dateReg;
    }

    public void setDateReg(LocalDate dateReg) {
        this.dateReg = dateReg;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }

}