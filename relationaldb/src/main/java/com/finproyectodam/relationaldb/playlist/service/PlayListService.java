package com.finproyectodam.relationaldb.playlist.service;

import com.finproyectodam.relationaldb.model.dto.PlaylistDTO;
import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.repository.PlayListsRepository;
import org.springframework.stereotype.Service;

/**
 * Servicio de playlist
 * @author cristian && Joel
 */
@Service
public class PlayListService {

    //variable del repositorio
    private final PlayListsRepository playListsRepository;

    /**
     * Constructor de la clase
     * @param playListsRepository el repositorio de playlist
     */
    public PlayListService(PlayListsRepository playListsRepository) {
        this.playListsRepository = playListsRepository;
    }

    /**
     * Metodo para guardar una playlist
     * @param playlistDTO la playlist a guardar
     */
    public void savePlayList(PlaylistDTO playlistDTO) {
        Playlist playlist = new Playlist(playlistDTO.getTitulo(), playlistDTO.getFechacre(),
                playlistDTO.getDescrip(), playlistDTO.getUserid());
        playListsRepository.save(playlist);
    }



}
