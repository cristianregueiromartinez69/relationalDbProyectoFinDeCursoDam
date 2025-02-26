package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Album;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de albumes
 * @author cristian && Joel
 * @version 1.0
 */
public interface AlbumesRepository extends JpaRepository<Album, Integer> {

    //metodo para encontrar albumes por id
    @EntityGraph(attributePaths = {"canciones"})
    Album findByid(Integer id);


}
