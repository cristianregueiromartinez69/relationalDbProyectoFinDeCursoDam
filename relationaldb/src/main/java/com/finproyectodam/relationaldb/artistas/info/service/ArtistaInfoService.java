package com.finproyectodam.relationaldb.artistas.info.service;

import com.finproyectodam.relationaldb.model.dto.ArtistaDTO;
import com.finproyectodam.relationaldb.model.entitys.Artista;
import com.finproyectodam.relationaldb.repository.ArtistasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de logica de artistas
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class ArtistaInfoService {

    //variable con el repositorio de la clase
    @Autowired
    private final ArtistasRepository artistasRepository;

    /**
     * Constructor de la clase
     * @param artistasRepository el repositorio de artistas
     */
    @Autowired
    public ArtistaInfoService(ArtistasRepository artistasRepository) {
        this.artistasRepository = artistasRepository;
    }

    /**
     * Metodo que busca artistas por nombre
     * @param nombre el nombre del artista
     * @return el artista o null
     */
    public Artista getArtistaByNombre(String nombre) {
        ArtistaDTO artistaDTO = new ArtistaDTO();
        artistaDTO.setNameart(nombre);
        return artistasRepository.findBynameart(artistaDTO.getNameart());
    }

    /**
     * Metodo que busca artistas por genero
     * @param genero el geneto del artista
     * @return una lista de artistas por genero o null
     */
    public List<Artista> getAllArtistasByGenero(String genero) {
        return artistasRepository.findArtistasBygeneroMusc(genero);
    }

    /**
     * Metodo que busca artistas por id
     * @param id el id del artista
     * @return el artista o null
     */
    public Artista getArtistaById(Integer id) {
        ArtistaDTO artistaDTO = new ArtistaDTO();
        artistaDTO.setId(id);
        return artistasRepository.findByid(artistaDTO.getId());
    }
}
