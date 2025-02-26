package com.finproyectodam.relationaldb.model.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Entidad de albumes de la base de datos
 * @author cristian && joel
 * @version 1.0
 */

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "albumes")
public class Album {

    //clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('albumes_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    //titulo del album
    @Size(max = 40)
    @NotNull
    @Column(name = "titulo", nullable = false, length = 40)
    private String titulo;

    //año de lanzamiento
    @NotNull
    @Column(name = "\"añolanz\"", nullable = false)
    private Integer anolanz;

    //artista al que pertenece
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artistaid", nullable = false)
    @JsonBackReference
    private Artista artistaid;

    //lista de canciones del album
    @OneToMany(mappedBy = "albumid")
    @JsonManagedReference
    private Set<Cancion> canciones = new LinkedHashSet<>();

    /**
     * Constructores de la clase
     * @param id la clave primaria
     * @param titulo el titulo del album
     * @param anolanz el año de lanzamiento
     * @param artistaid el artista al que pertenece el album
     * @param canciones las canciones del album
     */
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


    //getter y setter de la clase
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