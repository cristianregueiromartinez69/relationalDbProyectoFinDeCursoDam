package com.finproyectodam.relationaldb.playlist.service;

import com.finproyectodam.relationaldb.model.dto.PlaylistDTO;
import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.model.entitys.Usuario;
import com.finproyectodam.relationaldb.repository.PlayListsRepository;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import com.finproyectodam.relationaldb.usuarios.token.UsersTokens;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Servicio de playlist
 * @author cristian && Joel
 */
@Service
public class PlayListService {

    //variable del repositorio
    private final PlayListsRepository playListsRepository;
    private final UsuariosRepository usuariosRepository;
    private final UsersTokens usersTokens;

    /**
     * Constructor de la clase
     * @param playListsRepository el repositorio de playlist
     */
    public PlayListService(PlayListsRepository playListsRepository, UsuariosRepository usuariosRepository, UsersTokens usersTokens) {
        this.playListsRepository = playListsRepository;
        this.usuariosRepository = usuariosRepository;
        this.usersTokens = usersTokens;
    }

    /**
     * Metodo para guardar una playlist
     * @param playlistDTO la playlist a guardar
     */
    public void savePlayList(PlaylistDTO playlistDTO) {
        Playlist playlist = new Playlist(playlistDTO.getTitulo(), playlistDTO.getFechacre(),
                playlistDTO.getDescrip(), getCurrentUser(usersTokens.getUserTokens()));

        playListsRepository.save(playlist);
    }

    public Usuario getCurrentUser(ConcurrentHashMap<String, String> logginUsers){

        for(String usuario : logginUsers.keySet()){
            Optional<Usuario> userAuthenticator = usuariosRepository.findByEmail(usuario);
            if(userAuthenticator.isPresent()){
                return usuariosRepository.findByEmail(usuario).get();
            }
        }
        return null;
    }


}
