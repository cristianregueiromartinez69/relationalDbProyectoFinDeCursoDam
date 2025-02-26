package com.finproyectodam.relationaldb.model.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Representa la entidad 'Usuario' en la base de datos.
 * Esta clase mapea la tabla 'usuarios' y gestiona la información de los usuarios registrados en el sistema.
 * La clase está anotada con JPA para su persistencia en la base de datos.
 * @author cristian && Joel
 * @version 1.0
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "usuarios")
public class Usuario {

    //clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('usuarios_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    //alias del usuario
    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    //email del usuario
    @Size(max = 60)
    @NotNull
    @Column(name = "email", nullable = false, length = 60, unique = true)
    private String email;

    //contraseña del usuario
    @NotNull
    @Column(name = "password_u", nullable = false, length = Integer.MAX_VALUE)
    private String passwordU;

    //fecha de registro del usuario
    @ColumnDefault("CURRENT_DATE")
    @Column(name = "date_reg", nullable = false)
    private LocalDate dateReg;

    //lista de playlist del usuario
    @OneToMany(mappedBy = "userid")
    @JsonManagedReference
    private Set<Playlist> playlists = new LinkedHashSet<>();

    public Usuario() {

    }

    /**
     * Constructores completo para crear un nuevo usuario.
     *
     * @param id el ID del usuario.
     * @param username el nombre de usuario.
     * @param email el correo electrónico del usuario.
     * @param passwordU la contraseña del usuario.
     * @param dateReg la fecha de registro.
     * @param playlists las playlists asociadas al usuario.
     */
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

    public Usuario(String email, String passwordU) {
        this.email = email;
        this.passwordU = passwordU;
    }

    //getter y setter
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