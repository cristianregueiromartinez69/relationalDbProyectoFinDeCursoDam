package com.finproyectodam.relationaldb.randomplaylist.controller;

import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.randomplaylist.service.RandomPlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller de randomPlaylist
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/relationaldb/spotify")
public class RandomPlaylistRestController {

    //variable de servicio de playlist random
    private final RandomPlaylistService randomPlaylistService;

    /**
     * Constructor de la clase
     * @param randomPlaylistService el servicio de playlist random
     */
    public RandomPlaylistRestController(RandomPlaylistService randomPlaylistService) {
        this.randomPlaylistService = randomPlaylistService;
    }

    /**
     * Metodo Get para obtener una playlist random
     * @return la playlist random
     */
    @GetMapping("/inicio")
    public ResponseEntity<Playlist> getRandomPLaylistController(){
        try{
            Playlist playlist = randomPlaylistService.getRandomPlaylist();
            return ResponseEntity.ok(playlist);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
