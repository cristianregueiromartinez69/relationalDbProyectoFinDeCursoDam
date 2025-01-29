package com.finproyectodam.relationaldb.model.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlaylistCancionId implements Serializable {
    private static final long serialVersionUID = -6802567439587006573L;
    @NotNull
    @Column(name = "playlist_id", nullable = false)
    private Integer playlistId;

    @NotNull
    @Column(name = "cancion_id", nullable = false)
    private Integer cancionId;

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