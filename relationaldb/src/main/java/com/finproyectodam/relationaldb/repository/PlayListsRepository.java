package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListsRepository extends JpaRepository<Playlist, Integer> {

    Playlist findByid(Integer id);
}
