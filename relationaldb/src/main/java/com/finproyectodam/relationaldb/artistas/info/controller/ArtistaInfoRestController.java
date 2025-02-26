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

@RestController
@RequestMapping("/relationaldb/spotify/artistas/info")
public class ArtistaInfoRestController {

    @Autowired
    private final ArtistaInfoService artistaInfoService;

    @Autowired
    public ArtistaInfoRestController(ArtistaInfoService artistaInfoService) {
        this.artistaInfoService = artistaInfoService;
    }

    /*
    @GetMapping("/id/{id}")
    public ResponseEntity<Artista> getArtistaByIdController(@PathVariable Integer id) {
        Artista artista = artistaInfoService.getArtistaById(id);
        if (artista == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(artista);
    }
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
