package com.finproyectodam.relationaldb.model.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;


/**
 * Esta clase representa la clave compuesta para la relación entre la entidad Playlist y Cancion en una base de datos relacional.
 * Se utiliza en la base de datos para identificar de manera única una combinación de un ID de playlist y un ID de canción.
 * La clase es embebida en otras entidades de JPA para ser utilizada como una clave primaria compuesta.
 * @author cristian && Joel
 * @version 1.0
 */
@Embeddable
public class PlaylistCancionId implements Serializable {

    private static final long serialVersionUID = -6802567439587006573L;

    /**
     * ID de la playlist. Este campo no puede ser nulo.
     */
    @NotNull
    @Column(name = "playlist_id", nullable = false)
    private Integer playlistId;

    /**
     * ID de la canción. Este campo no puede ser nulo.
     */
    @NotNull
    @Column(name = "cancion_id", nullable = false)
    private Integer cancionId;

    //getter y setter
    public Integer getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public Integer getCancionId() {
        return cancionId;
    }

    public void setCancionId(Integer cancionId) {
        this.cancionId = cancionId;
    }

    /**
     * Compara dos objetos de tipo PlaylistCancionId para determinar si son iguales.
     *
     * @param o el objeto a comparar.
     * @return true si ambos objetos son iguales, de lo contrario, false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlaylistCancionId entity = (PlaylistCancionId) o;
        return Objects.equals(this.playlistId, entity.playlistId) &&
                Objects.equals(this.cancionId, entity.cancionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, cancionId);
    }

}