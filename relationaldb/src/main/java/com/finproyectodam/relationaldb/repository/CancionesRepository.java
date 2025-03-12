package com.finproyectodam.relationaldb.repository;

import com.finproyectodam.relationaldb.model.entitys.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Repositorio de canciones
 * @author cristian && Joel
 * @version 1.0
 */
public interface CancionesRepository extends JpaRepository<Cancion, Integer> {

    /**
     * Metodo para encontrar canciones por id
     * @param id el id de la cancion
     * @return la cancion o null
     */
    Cancion findByid(Integer id);

    /**
     * Metodo para obtener una cancion o canciones por titulo
     * @param nombre el nombre de la cancion
     * @return la lista de canciones
     */
    List<Cancion> findBytitulo(String nombre);

}
