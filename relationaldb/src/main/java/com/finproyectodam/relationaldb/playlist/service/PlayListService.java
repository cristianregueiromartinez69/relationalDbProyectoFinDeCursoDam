package com.finproyectodam.relationaldb.playlist.service;

import com.finproyectodam.relationaldb.fichero.LecturaExcrituraFicheros;
import com.finproyectodam.relationaldb.model.dto.PlaylistDTO;
import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.model.entitys.Usuario;
import com.finproyectodam.relationaldb.repository.PlayListsRepository;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio de playlist
 * @author cristian && Joel
 */
@Service
public class PlayListService {

    //variable del repositorio
    private final PlayListsRepository playListsRepository;
    private final UsuariosRepository usuariosRepository;
    private final LecturaExcrituraFicheros lef;

    /**
     * Constructor de la clase
     * @param playListsRepository el repositorio de playlist
     */
    public PlayListService(PlayListsRepository playListsRepository, UsuariosRepository usuariosRepository, LecturaExcrituraFicheros lef) {
        this.playListsRepository = playListsRepository;
        this.usuariosRepository = usuariosRepository;
        this.lef = lef;
    }

    /**
     * Metodo para guardar una playlist
     * @param playlistDTO la playlist a guardar
     */
    public void savePlayList(PlaylistDTO playlistDTO) {
        Playlist playlist = new Playlist(playlistDTO.getTitulo(), playlistDTO.getFechacre(),
                playlistDTO.getDescrip(), getuserLoggin());

        System.out.println(playlist.getTitulo() + playlist.getFechacre() + playlist.getDescrip() + playlist.getUserid());
        playListsRepository.save(playlist);
    }

    public Usuario getuserLoggin(){
        Optional<Usuario> userLoggin = usuariosRepository.findByEmail(lef.readAliasLogueado());
        return userLoggin.orElse(null);
    }



}
