package com.finproyectodam.relationaldb.model.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * entidas cancion de la base de datos
 * @author cristian && Joel
 * version 1.0
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "canciones")
public class Cancion {

    //clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('canciones_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    //titulo de la cancion
    @Size(max = 40)
    @NotNull
    @Column(name = "titulo", nullable = false, length = 40)
    private String titulo;

    //duracion de la cancion
    @NotNull
    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    //url de la cancion
    @Size(max = 300)
    @NotNull
    @Column(name = "urlcancion", nullable = false, length = 300)
    private String urlcancion;

    //nombre  al que pertenece la cancion
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "artistaid", nullable = false)
    @JsonBackReference
    private Artista artistaid;

    //album al que pertenece la cancion
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "albumid", nullable = false)
    @JsonBackReference
    private Album albumid;

    //relacion muchos a muchos de la playlist
    @ManyToMany
    @JoinTable(name = "playlist_cancion",
            joinColumns = @JoinColumn(name = "cancion_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    private Set<Playlist> playlists = new LinkedHashSet<>();

    public Cancion() {
    }

    /**
     * Constructores de la clase
     * @param id la clave primaria
     * @param titulo el titulo de la cancion
     * @param duracion la duracion de la cancion
     * @param urlcancion la url de la cancion
     * @param artistaid el artista al que pertenece la cancion
     * @param albumid el album al que perteence la cancion
     * @param playlists la playlist a la que pertenece
     */
    public Cancion(Integer id, String titulo, Integer duracion, String urlcancion, Artista artistaid, Album albumid, Set<Playlist> playlists) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.urlcancion = urlcancion;
        this.artistaid = artistaid;
        this.albumid = albumid;
        this.playlists = playlists;
    }

    public Cancion(String titulo, Integer duracion, String urlcancion, Artista artistaid, Album albumid) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.urlcancion = urlcancion;
        this.artistaid = artistaid;
        this.albumid = albumid;
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

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getUrlcancion() {
        return urlcancion;
    }

    public void setUrlcancion(String urlcancion) {
        this.urlcancion = urlcancion;
    }

    public Artista getArtistaid() {
        return artistaid;
    }

    public void setArtistaid(Artista artistaid) {
        this.artistaid = artistaid;
    }

    public Album getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Album albumid) {
        this.albumid = albumid;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }

}