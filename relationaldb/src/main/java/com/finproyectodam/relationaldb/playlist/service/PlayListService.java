package com.finproyectodam.relationaldb.playlist.service;

import com.finproyectodam.relationaldb.model.dto.PlaylistDTO;
import com.finproyectodam.relationaldb.model.entitys.*;
import com.finproyectodam.relationaldb.repository.CancionesRepository;
import com.finproyectodam.relationaldb.repository.PlayListsRepository;
import com.finproyectodam.relationaldb.repository.PlaylistCancionRepository;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import com.finproyectodam.relationaldb.usuarios.token.UsersTokens;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
    private final CancionesRepository cancionesRepository;
    private final PlaylistCancionRepository playlistCancionRepository;

    /**
     * Constructor de la clase
     * @param playListsRepository el repositorio de playlist
     */
    public PlayListService(PlayListsRepository playListsRepository, UsuariosRepository usuariosRepository, UsersTokens usersTokens, CancionesRepository cancionesRepository, PlaylistCancionRepository playlistCancionRepository) {
        this.playListsRepository = playListsRepository;
        this.usuariosRepository = usuariosRepository;
        this.usersTokens = usersTokens;
        this.cancionesRepository = cancionesRepository;
        this.playlistCancionRepository = playlistCancionRepository;
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

    /**
     * Metodo para añadir canciones a la playlist
     * @param playlistId el id de la playlist
     * @param cancionId el id de la cancion
     */
    @Transactional
    public void addSongPlayList(Integer playlistId, Integer cancionId){
        if(checkUserLoggingAddSong(playlistId)){
            Playlist playlist = playListsRepository.findById(playlistId).get();
            Cancion cancion = cancionesRepository.findById(cancionId).get();

            PlaylistCancionId playlistCancionId = new PlaylistCancionId();
            playlistCancionId.setCancionId(cancionId);
            playlistCancionId.setPlaylistId(playlist.getId());

            PlaylistCancion playlistCancion = new PlaylistCancion();
            playlistCancion.setId(playlistCancionId);
            playlistCancion.setPlaylist(playlist);
            playlistCancion.setCancion(cancion);

            playlistCancionRepository.save(playlistCancion);
        }
        else{
            throw new RuntimeException("Usuario no logueado, fuera hacker!!");
        }
    }

    /**
     * Metodo que devuelve todas las playlist del usuario
     * @return las playlist del usuario
     */
    public List<Playlist> getAllPlaylistService(){
        Usuario userAuthenticator = getCurrentUser(usersTokens.getUserTokens());
        return playListsRepository.findAllByuserid(userAuthenticator);
    }

    /**
     * Metodo para saber si estás añadiendo una cancion a una playlist que es tuya
     * @param playlistId el id de la playlist
     * @return true o false dependiendo de si eres el dueño o no
     */
    private boolean checkUserLoggingAddSong(Integer playlistId){
        Playlist playlist = playListsRepository.findById(playlistId).get();
        Usuario userLoggin = getCurrentUser(usersTokens.getUserTokens());
        Usuario userPlaylist = playlist.getUserid();
        return userPlaylist.getEmail().equals(userLoggin.getEmail());
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
