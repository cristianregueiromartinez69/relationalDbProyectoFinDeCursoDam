package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio de la clase
 * @author cristian && Joel
 * @version 1.0
 */
@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String nombre);
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByPasswordU(String passwordU);
}
