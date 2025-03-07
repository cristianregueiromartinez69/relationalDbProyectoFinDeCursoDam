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
     * Metodo para devolver todas las playList del usuario logueado
     * @return la lista de playlist que tenga el usuario logueado
     */
    List<Playlist> findByUserid(Usuario user);


    /**
     * Metodo para devolver una playlist del usuario autenticado
     * @param id el is a buscar
     * @param user el usuario logueado
     * @return la playlist o null
     */
    Playlist findByidAndUserid(Integer id, Usuario user);
}
