package com.finproyectodam.relationaldb.model.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('usuarios_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 60)
    @NotNull
    @Column(name = "email", nullable = false, length = 60)
    private String email;

    @NotNull
    @Column(name = "password_u", nullable = false, length = Integer.MAX_VALUE)
    private String passwordU;

    @ColumnDefault("CURRENT_DATE")
    @Column(name = "date_reg", nullable = false)
    private LocalDate dateReg;

    @OneToMany(mappedBy = "userid")
    private Set<Playlist> playlists = new LinkedHashSet<>();

    public Usuario() {

    }

    public Usuario(Integer id, String username, String email, String passwordU, LocalDate dateReg, Set<Playlist> playlists) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordU = passwordU;
        this.dateReg = dateReg;
        this.playlists = playlists;
    }

    public Usuario(String username, String email, String passwordU, LocalDate dateReg, Set<Playlist> playlists) {
        this.username = username;
        this.email = email;
        this.passwordU = passwordU;
        this.dateReg = dateReg;
        this.playlists = playlists;
    }

    public Usuario(String username, String email, String passwordU, LocalDate dateReg) {
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