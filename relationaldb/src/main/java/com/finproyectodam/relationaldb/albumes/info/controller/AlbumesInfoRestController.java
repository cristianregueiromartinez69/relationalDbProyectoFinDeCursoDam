package com.finproyectodam.relationaldb.albumes.info.controller;

import com.finproyectodam.relationaldb.albumes.info.Service.AlbumesInfoService;
import com.finproyectodam.relationaldb.model.entitys.Album;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller de albumes
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/relationaldb/spotify/albumes/info")
public class AlbumesInfoRestController {

    //variable del servicio de albumes
    private final AlbumesInfoService albumesInfoService;

    /**
     * Constructor de la clase
     * @param albumesInfoService el servicio de albumes
     */
    public AlbumesInfoRestController(AlbumesInfoService albumesInfoService) {
        this.albumesInfoService = albumesInfoService;
    }

    /**
     * Metodo getter para obtener un album por el id
     * @param id el id del album
     * @return el album o null
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<Album> getAlbumByIdController(@PathVariable Integer id) {
            Album album = albumesInfoService.getAlbumByIdService(id);
            if(album == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(album);
    }

    /**
     * Metodo getter para obtener un album por el titulo
     * @param titulo el titulo del album
     * @return el album o null
     */
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Album> getAlbumByTituloController(@PathVariable String titulo) {
        Album album = albumesInfoService.getAlbumByTituloService(titulo);
        if(album == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(album);
    }

    /**
     * Metodo getter para obtener una lista de albumes entre años de lanzamiento
     * @param anoInicio el año de inicio
     * @param anoFin el año de fin
     * @return una lista de albumes o null
     */
    @GetMapping("/anolanz")
    public ResponseEntity<List<Album>> getAlbumesByAnoLanzController(@RequestParam("anoInit") Integer anoInicio,
                                                               @RequestParam("anoFin") Integer anoFin) {
        List<Album> album = albumesInfoService.getAlbumsByAnoLanzService(anoInicio, anoFin);
        if(album == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(album);
    }


}
