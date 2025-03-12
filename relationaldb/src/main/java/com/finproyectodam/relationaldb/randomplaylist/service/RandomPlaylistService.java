package com.finproyectodam.relationaldb.randomplaylist.service;

import com.finproyectodam.relationaldb.excepciones.playlist.IdExcepction;
import com.finproyectodam.relationaldb.excepciones.usuarios.LoginUserExcepcion;
import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.model.entitys.PlaylistCancion;
import com.finproyectodam.relationaldb.model.entitys.Usuario;
import com.finproyectodam.relationaldb.playlist.service.PlayListService;
import com.finproyectodam.relationaldb.repository.PlayListsRepository;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import com.finproyectodam.relationaldb.usuarios.token.UsersTokens;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de playlist aleatoria al entrar en la web
 * @author cristian
 * @version 1.0
 */
@Service
public class RandomPlaylistService {

    //variables finales de la clase
    private final UsuariosRepository usuariosRepository;
    private final PlayListsRepository playlistsRepository;
    private final UsersTokens usersTokens;
    private final PlayListService playListService;
    private static final Integer ID_USER_ADMIN_RANDOM_PLAYLIST = 8;

    /**
     * Constructor de la clase
     * @param usuariosRepository el repositorio de usuarios
     * @param playlistsRepository el repositorio de playlist
     * @param usersTokens el repositorio de usuarios registrados
     * @param playListService el repositorio de playlist service
     */
    public RandomPlaylistService(UsuariosRepository usuariosRepository, PlayListsRepository playlistsRepository, UsersTokens usersTokens, PlayListService playListService) {
        this.usuariosRepository = usuariosRepository;
        this.playlistsRepository = playlistsRepository;
        this.usersTokens = usersTokens;
        this.playListService = playListService;
    }

    /**
     * Metodo principal para obtener una playlist aleatoria
     * @return la playlist recibida
     */
    public Playlist getRandomPlaylist() {
        List<Playlist> adminPlaylists = getAllAdminPlaylists();

        if(adminPlaylists == null) {
            adminPlaylists = new ArrayList<>();
        }

        List<Playlist> userPlaylist = userPlaylistService();
        sumAllPlaylist(adminPlaylists, userPlaylist);


        int sizePlaylist = adminPlaylists.size();
        int numRandom = (int)(Math.random() * sizePlaylist);
        return adminPlaylists.get(numRandom);
    }

    /**
     * Metodo privado para sumar unas listas de datos
     * @param adminPlaylist la playlist de recomendado
     * @param userPlaylist la playlist del usuario
     */
    private void sumAllPlaylist(List<Playlist> adminPlaylist, List<Playlist> userPlaylist){
        if(userPlaylist != null && !userPlaylist.isEmpty()){
            adminPlaylist.addAll(userPlaylist);
        }
    }

    /**
     * Metodo para obtener las playlist del usuario, en caso de tenerlas
     * @return la lista de playlist o null
     */
    private List<Playlist> userPlaylistService() {
        Usuario userAuthenticator = playListService.getCurrentUser(usersTokens.getUserTokens());
        if(userAuthenticator == null){
            throw new LoginUserExcepcion("Usuario no logueado, fuera hacker!!");
        }
        List<Playlist> playlistUser = playlistsRepository.findByUserid(userAuthenticator);
        if(playlistUser.isEmpty()){
            return null;
        }
        return playlistsRepository.findByUserid(userAuthenticator);
    }

    /**
     * Metodo para obtener las playlist de los recomendados
     * @return la lista de playlist recomendadas
     */
    private List<Playlist> getAllAdminPlaylists() {
        Usuario usuarioAdmin = usuariosRepository.findByid(ID_USER_ADMIN_RANDOM_PLAYLIST);
        return playlistsRepository.findByUserid(usuarioAdmin);
    }



}
