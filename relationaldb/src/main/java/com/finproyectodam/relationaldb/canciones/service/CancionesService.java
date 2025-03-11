package com.finproyectodam.relationaldb.canciones.service;

import com.finproyectodam.relationaldb.model.entitys.Cancion;
import com.finproyectodam.relationaldb.repository.CancionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de canciones
 * @author cristian
 * @version 1.0
 */
@Service
public class CancionesService {

    //repositorio de las canciones
    private final CancionesRepository cancionesRepository;

    /**
     * Constructor de la clase
     * @param cancionesRepository el repositorio de las canciones
     */
    public CancionesService(CancionesRepository cancionesRepository) {
        this.cancionesRepository = cancionesRepository;
    }

    /**
     * Metodo para obtener una lista de todas las canciones de la base de datos
     * @return la lista de canciones o null
     */
    public List<Cancion> getAllSongsService(){
        List<Cancion> cancionList = cancionesRepository.findAll();
        if(cancionList.isEmpty()){
            return null;
        }
        return cancionList;
    }

    /**
     * Metodo para obtener una cancion de la base de datos por el id
     * @param id el id de la cancion
     * @return la cancion o null
     */
    public Cancion getCancionByIdService(Integer id){
        return cancionesRepository.findByid(id);
    }

    /**
     * Metodo para obtener del repositorio una lista de canciones por titulo
     * @param titulo el titulo de la cancion
     * @return la cancion, canciones o null
     */
    public List<Cancion> getCancionesByTituloService(String titulo){
        return cancionesRepository.findBytitulo(titulo);
    }
}
