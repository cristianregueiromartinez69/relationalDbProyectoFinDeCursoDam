package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistasRepository extends JpaRepository<Artista, Integer>{


    Artista findBynameart(String nombre);
    Artista findByid(Integer id);
    List<Artista> findArtistasBygeneroMusc(String genero);

}
