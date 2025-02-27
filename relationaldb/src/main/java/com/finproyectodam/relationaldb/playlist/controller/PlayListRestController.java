package com.finproyectodam.relationaldb.playlist.controller;

import com.finproyectodam.relationaldb.model.dto.PlaylistDTO;
import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.playlist.service.PlayListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().body("Playlist creada correctamente");
    }
}
