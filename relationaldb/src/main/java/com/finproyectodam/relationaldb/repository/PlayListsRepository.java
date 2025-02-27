package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de playList
 * @author cristian && Joel
 * @version 1.0
 */
public interface PlayListsRepository extends JpaRepository<Playlist, Integer> {

    /**
     * Metodo para encontrar una playList por id
     * @param id el id de la PlayList
     * @return la playList o null
     */
    Playlist findByid(Integer id);
}
