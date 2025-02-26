package com.finproyectodam.relationaldb.albumes.info.Service;

import com.finproyectodam.relationaldb.model.entitys.Album;
import com.finproyectodam.relationaldb.repository.AlbumesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio con la lógica de búsqueda de albumes
 * @author cristian
 * @version 1.0
 */
@Service
public class AlbumesInfoService {

    //variable con el repositorio de albumes
    private final AlbumesRepository albumesRepository;

    /**
     * Constructor de la clase
     * @param albumesRepository el repositorio de albumes
     */
    public AlbumesInfoService(AlbumesRepository albumesRepository) {
        this.albumesRepository = albumesRepository;
    }

    /**
     * Metodo para obtener albumes por el id
     * @param id el id del album
     * @return el album o null
     */
    public Album getAlbumByIdService(Integer id) {
        return albumesRepository.findByid(id);
    }

    /**
     * Metodo para obtener albumes por el titulo
     * @param  titulo el titulo del album
     * @return el album o null
     */
    public Album getAlbumByTituloService(String titulo) {
        return albumesRepository.findBytitulo(titulo);
    }

    /**
     * Metodo para obtener albumes entre años de lanzamiento
     * @param anoInit el año de inicio
     * @param anoFin el año de fin
     * @return una lista de albumes o null
     */
    public List<Album> getAlbumsByAnoLanzService(Integer anoInit, Integer anoFin) {
        return albumesRepository.findByanolanzBetween(anoInit, anoFin);
    }
}
