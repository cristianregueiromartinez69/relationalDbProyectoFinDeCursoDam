package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Cancion;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionesRepository extends JpaRepository<Cancion, Integer> {

    Cancion findByid(Integer id);
}
