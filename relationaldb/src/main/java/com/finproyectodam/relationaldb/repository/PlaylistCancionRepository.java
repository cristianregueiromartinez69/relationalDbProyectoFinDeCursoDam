package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Cancion;
import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.model.entitys.PlaylistCancion;
import com.finproyectodam.relationaldb.model.entitys.PlaylistCancionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistCancionRepository extends JpaRepository<PlaylistCancion, PlaylistCancionId> {

    /**
     * Metodo para borrar la playlist de la tabla intermedia
     * @param playlist el objeto playlist
     */
    void deleteByplaylist(Playlist playlist);

    /**
     * Metodo para eliminar una cancion de la playlist
     * @param playlist el objeto playList
     * @param cancion el objeto cancion
     */
    void deleteByplaylistAndCancion(Playlist playlist, Cancion cancion);
}
