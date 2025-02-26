package com.finproyectodam.relationaldb.artistas.info.controller;

import com.finproyectodam.relationaldb.artistas.info.service.ArtistaInfoService;
import com.finproyectodam.relationaldb.model.entitys.Artista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest controller de artistas
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/relationaldb/spotify/artistas/info")
public class ArtistaInfoRestController {

    //variable de servicios de artista
    @Autowired
    private final ArtistaInfoService artistaInfoService;

    /**
     * Constructor de la clase
     * @param artistaInfoService el servicio de artistas
     */
    @Autowired
    public ArtistaInfoRestController(ArtistaInfoService artistaInfoService) {
        this.artistaInfoService = artistaInfoService;
    }

    /**
     * Metodo Get para obtener un artista por id
     * @param id el id del artista
     * @return el artista o null
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<Artista> getArtistaByIdController(@PathVariable Integer id) {
        Artista artista = artistaInfoService.getArtistaById(id);
        if (artista == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(artista);
    }

    /**
     * Metodo Get para obtener un artista por nombre
     * @param nombre el nombre del artista
     * @return el artista o null
     */
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Artista> getArtistaNombreRestController(@PathVariable String nombre) {
            Artista artista = artistaInfoService.getArtistaByNombre(nombre);
            if (artista == null) {
                return ResponseEntity.notFound().build();
            }
            System.out.println(artista);
            return ResponseEntity.ok(artista);
    }

    /**
     * Metodo Get para obtener una lista de artistas por genero
     * @param genero el genero del artista
     * @return la lista de artistas o null
     */
    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Artista>> getArtistaGeneroRestController(@PathVariable String genero) {
        List<Artista> artistaList = artistaInfoService.getAllArtistasByGenero(genero);
        if(artistaList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        for(Artista artista : artistaList) {
            System.out.println(artista);
        }
        return ResponseEntity.ok(artistaList);
    }
}
