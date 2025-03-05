package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.PlaylistCancion;
import com.finproyectodam.relationaldb.model.entitys.PlaylistCancionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistCancionRepository extends JpaRepository<PlaylistCancion, PlaylistCancionId> {


}
