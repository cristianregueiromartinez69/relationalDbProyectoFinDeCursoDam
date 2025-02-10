package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
