package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Album;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;

public interface AlbumesRepository extends JpaRepository<Album, Integer> {

    @EntityGraph(attributePaths = {"canciones"})
    Album findByid(Integer id);


}
