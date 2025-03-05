package com.finproyectodam.relationaldb.playlist.controller;

import com.finproyectodam.relationaldb.model.dto.PlaylistDTO;
import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.playlist.service.PlayListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relationaldb/spotify/playlist")
public class PlayListRestController {

    private final PlayListService playListService;

    public PlayListRestController(PlayListService playListService) {
        this.playListService = playListService;
    }

    @PostMapping("/crear")
    public ResponseEntity<String> savePlayListController(@RequestBody PlaylistDTO playlistDTO) {
        try{
            playListService.savePlayList(playlistDTO);
            return ResponseEntity.ok("Playlist creada correctamente");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Metodo post para añadir una cancion a una playlist
     * @param playlistId el id de la playlist
     * @param cancionId el id de la cancion
     * @return un mensaje diciendo de si se añadio o no la cancion
     */
    @PostMapping("/{playlistId}/cancion/{cancionId}")
    public ResponseEntity<String> addCancionPlaylistController(@PathVariable Integer playlistId, @PathVariable Integer cancionId) {
        try{
            playListService.addSongPlayList(playlistId, cancionId);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Cancion añadida a la playlist correctamente");
    }

    /**
     * Metodo para obtener todas las playlist que sean del usuario logueado
     * @return la lista de playlist o null
     */
    @GetMapping("/info")
    public ResponseEntity<List<Playlist>> getPlaylistController() {
        try{
            List<Playlist> playlistList = playListService.getAllPlaylistService();
            return ResponseEntity.ok(playlistList);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
}
