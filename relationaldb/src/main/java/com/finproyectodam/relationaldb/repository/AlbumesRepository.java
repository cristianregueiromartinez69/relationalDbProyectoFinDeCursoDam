package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Album;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio de albumes
 * @author cristian && Joel
 * @version 1.0
 */
public interface AlbumesRepository extends JpaRepository<Album, Integer> {

    //metodo para encontrar albumes por id
    @EntityGraph(attributePaths = {"canciones"})
    Album findByid(Integer id);

    //metodo para encontrar albumes por nombre
    @EntityGraph(attributePaths = {"canciones"})
    Album findBytitulo(String nombre);

    //metodo para encontrar albumes entre años de lanzamiento
    @EntityGraph(attributePaths = {"canciones"})
    List<Album> findByanolanzBetween(Integer anoInit, Integer anoFin);

}
