package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Cancion;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repositorio de canciones
 * @author cristian && Joel
 * @version 1.0
 */
public interface CancionesRepository extends JpaRepository<Cancion, Integer> {

    /**
     * Metodo para encontrar canciones por id
     * @param id el id de la cancion
     * @return la cancion o null
     */
    Cancion findByid(Integer id);
}
