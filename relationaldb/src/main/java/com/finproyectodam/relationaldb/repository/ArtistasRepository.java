package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Artista;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de artistas
 * @author cristian && Joel
 * @version 1.0
 */
@Repository
public interface ArtistasRepository extends JpaRepository<Artista, Integer>{

    /**
     * Metodo para encontrar un artista por nombre
     * @param nombre el nombre del artista
     * @return el artista o null
     */
    @EntityGraph(attributePaths = {"albumes", "canciones"})
    Artista findBynameart(String nombre);

    /**
     * Metodo para encontrar un artista por id
     * @param id el id del artista
     * @return el artista o null
     */
    @EntityGraph(attributePaths = {"albumes", "canciones"})
    Artista findByid(Integer id);

    /**
     * Metodo para encontrar una lista artistas por genero musical
     * @param genero el genero musical del artista
     * @return la lista de artistas o null
     */
    @EntityGraph(attributePaths = {"albumes", "canciones"})
    List<Artista> findArtistasBygeneroMusc(String genero);

}
