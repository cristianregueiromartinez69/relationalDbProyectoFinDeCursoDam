package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.model.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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

    /**
     * Metodo para devolver todas las playList del usuario logueado
     * @return la lista de playlist que tenga el usuario logueado
     */
    List<Playlist> findAllByuserid(Usuario user);


}
