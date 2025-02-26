package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Artista;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistasRepository extends JpaRepository<Artista, Integer>{

    @EntityGraph(attributePaths = {"albumes", "canciones"})
    Artista findBynameart(String nombre);

    @EntityGraph(attributePaths = {"albumes", "canciones"})
    Artista findByid(Integer id);

    @EntityGraph(attributePaths = {"albumes", "canciones"})
    List<Artista> findArtistasBygeneroMusc(String genero);

}
