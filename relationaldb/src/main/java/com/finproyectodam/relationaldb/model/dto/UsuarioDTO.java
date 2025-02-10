package com.finproyectodam.relationaldb.model.dto;

import com.finproyectodam.relationaldb.model.entitys.Playlist;


import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;


public class UsuarioDTO {

    private Integer id;


    private String username;


    private String email;


    private String passwordU;


    private LocalDate dateReg;

    private Set<Playlist> playlists = new LinkedHashSet<>();

    public UsuarioDTO() {

    }

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