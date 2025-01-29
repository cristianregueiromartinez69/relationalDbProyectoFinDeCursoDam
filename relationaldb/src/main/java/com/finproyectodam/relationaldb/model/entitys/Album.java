package com.finproyectodam.relationaldb.model.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "albumes")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('albumes_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 40)
    @NotNull
    @Column(name = "titulo", nullable = false, length = 40)
    private String titulo;

    @NotNull
    @Column(name = "\"añolanz\"", nullable = false)
    private Integer anolanz;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artistaid", nullable = false)
    private Artista artistaid;

    @OneToMany(mappedBy = "albumid")
    private Set<Cancion> canciones = new LinkedHashSet<>();

    public Album(Integer id, String titulo, Integer anolanz, Artista artistaid, Set<Cancion> canciones) {
        this.id = id;
        this.titulo = titulo;
        this.anolanz = anolanz;
        this.artistaid = artistaid;
        this.canciones = canciones;
    }

    public Album(String titulo, Integer anolanz, Artista artistaid) {
        this.titulo = titulo;
        this.anolanz = anolanz;
        this.artistaid = artistaid;
    }

    public Album(String titulo, Integer anolanz, Artista artistaid, Set<Cancion> canciones) {
        this.titulo = titulo;
        this.anolanz = anolanz;
        this.artistaid = artistaid;
        this.canciones = canciones;
    }

    public Album() {

    }


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