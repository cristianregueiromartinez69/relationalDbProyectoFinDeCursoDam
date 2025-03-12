package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
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

    /**
     * Busqueda de un usuario por su id
     * @param id el id del usuario
     * @return el usuario a devolver por id
     */
    Usuario findByid(Integer id);
    //encontrar a un usuario por alias
    @EntityGraph(attributePaths = {"playlists"})
    Optional<Usuario> findByUsername(String nombre);

    //encontrar a un usuario por email
    @EntityGraph(attributePaths = {"playlists"})
    Optional<Usuario> findByEmail(String email);

    //encontrar a un usuario por password
    @EntityGraph(attributePaths = {"playlists"})
    Optional<Usuario> findByPasswordU(String passwordU);
}
