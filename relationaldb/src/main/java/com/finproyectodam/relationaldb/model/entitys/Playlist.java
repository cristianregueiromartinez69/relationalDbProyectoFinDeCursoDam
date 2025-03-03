package com.finproyectodam.relationaldb.model.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * entidas playlist de la base de datos
 * @author cristian && Joel
 * version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "playlist")
public class Playlist {

    //la clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('playlist_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    //el titulo de la playlist
    @Size(max = 30)
    @NotNull
    @Column(name = "titulo", nullable = false, length = 30)
    private String titulo;

    // la fecha de creacion
    @NotNull
    @Column(name = "fechacre", nullable = false)
    private LocalDate fechacre;

    //descripcion de la playlist
    @Size(max = 100)
    @Column(name = "descrip", length = 100)
    private String descrip;

    //usuario al que pertenece la playlist
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    @JsonBackReference
    @JsonIgnore
    private Usuario userid;

    //relacion muchos a muchos con canciones
    @ManyToMany
    @JoinTable(name = "playlist_cancion",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "cancion_id"))
    @JsonIgnore
    private Set<Cancion> canciones = new LinkedHashSet<>();


    public Playlist() {
    }

    /**
     * Constructores de la clase
     * @param id la clave primaria
     * @param titulo el titulo de la playlist
     * @param fechacre la fecha de creacion de la playlist
     * @param descrip la descripcion de la playlist
     * @param userid el usuario al que pertenece la playlist
     * @param canciones las canciones de la playlist
     */
    public Playlist(Integer id, String titulo, LocalDate fechacre, String descrip, Usuario userid, Set<Cancion> canciones) {
        this.id = id;
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
        this.userid = userid;
        this.canciones = canciones;
    }

    public Playlist(String titulo, LocalDate fechacre, String descrip, Usuario userid, Set<Cancion> canciones) {
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
        this.userid = userid;
        this.canciones = canciones;
    }

    public Playlist(String titulo, LocalDate fechacre, String descrip, Usuario userid) {
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
        this.userid = userid;
    }

    public Playlist(String titulo, LocalDate fechacre, String descrip) {
        this.titulo = titulo;
        this.fechacre = fechacre;
        this.descrip = descrip;
    }

    //getter y setter
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