package com.finproyectodam.relationaldb.model.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * entidas artista de la base de datos
 * @author cristian && Joel
 * version 1.0
 */
@Entity
@Table(name = "artistas")
public class Artista {

    //clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('artistas_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    //nombre del artista
    @Size(max = 40)
    @NotNull
    @Column(name = "nameart", nullable = false, length = 40)
    private String nameart;

    //genero musical
    @Size(max = 30)
    @NotNull
    @Column(name = "genero_musc", nullable = false, length = 30)
    private String generoMusc;

    //descripcion del artista
    @Size(max = 60)
    @Column(name = "descrip", length = 60)
    private String descrip;

    //lista de albumes
    @OneToMany(mappedBy = "artistaid")
    private Set<Album> albumes = new LinkedHashSet<>();

    //lista de canciones del artista
    @OneToMany(mappedBy = "artistaid")
    private Set<Cancion> canciones = new LinkedHashSet<>();

    /**
     * Constructores de la clase
     * @param id la clave primaria
     * @param nameart el nombre del artista
     * @param generoMusc el genero musical
     * @param descrip la descripcion
     * @param albumes los albumes del artista
     * @param canciones las canciones del artista
     */
    public Artista(Integer id, String nameart, String generoMusc, String descrip, Set<Album> albumes, Set<Cancion> canciones) {
        this.id = id;
        this.nameart = nameart;
        this.generoMusc = generoMusc;
        this.descrip = descrip;
        this.albumes = albumes;
        this.canciones = canciones;
    }

    public Artista(String nameart, String generoMusc, String descrip) {
        this.nameart = nameart;
        this.generoMusc = generoMusc;
        this.descrip = descrip;
    }

    public Artista(String nameart, String generoMusc, String descrip, Set<Album> albumes, Set<Cancion> canciones) {
        this.nameart = nameart;
        this.generoMusc = generoMusc;
        this.descrip = descrip;
        this.albumes = albumes;
        this.canciones = canciones;
    }

    public Artista() {

    }

    //getter y setter de la clase
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