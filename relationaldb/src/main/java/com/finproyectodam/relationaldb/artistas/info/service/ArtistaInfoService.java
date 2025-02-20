package com.finproyectodam.relationaldb.artistas.info.service;

import com.finproyectodam.relationaldb.model.dto.ArtistaDTO;
import com.finproyectodam.relationaldb.model.entitys.Artista;
import com.finproyectodam.relationaldb.repository.ArtistasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaInfoService {

    @Autowired
    private final ArtistasRepository artistasRepository;

    @Autowired
    public ArtistaInfoService(ArtistasRepository artistasRepository) {
        this.artistasRepository = artistasRepository;
    }

    public Artista getArtistaByNombre(String nombre) {
        ArtistaDTO artistaDTO = new ArtistaDTO();
        artistaDTO.setNameart(nombre);
        return artistasRepository.findBynameart(artistaDTO.getNameart());
    }

    public List<Artista> getAllArtistasByGenero(String genero) {
        return artistasRepository.findArtistasBygeneroMusc(genero);
    }
}
