package com.finproyectodam.relationaldb.model.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * entida intermedia de muchos a muchos de playlist y canciones
 * @author cristian && Joel
 * version 1.0
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "playlist_cancion")
public class PlaylistCancion {

    //id de la playlist
    @EmbeddedId
    private PlaylistCancionId id;

    //la playlist
    @MapsId("playlistId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "playlist_id", nullable = false)
    @JsonBackReference
    private Playlist playlist;

    //la cancion de la playlist
    @MapsId("cancionId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cancion_id", nullable = false)
    @JsonBackReference
    private Cancion cancion;

    /**
     * Constructores de la clase
     * @param id el id de la playlist
     * @param playlist la playlist
     * @param cancion la cancion
     */
    public PlaylistCancion(PlaylistCancionId id, Playlist playlist, Cancion cancion) {
        this.id = id;
        this.playlist = playlist;
        this.cancion = cancion;
    }

    public PlaylistCancion() {

    }

    //getter y setter
    public PlaylistCancionId getId() {
        return id;
    }

    public void setId(PlaylistCancionId id) {
        this.id = id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

}