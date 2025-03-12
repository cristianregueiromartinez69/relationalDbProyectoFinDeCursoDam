package com.finproyectodam.relationaldb.randomplaylist.service;

import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.model.entitys.Usuario;
import com.finproyectodam.relationaldb.playlist.service.PlayListService;
import com.finproyectodam.relationaldb.repository.PlayListsRepository;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import com.finproyectodam.relationaldb.usuarios.token.UsersTokens;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RandomPlaylistService {

    private final UsuariosRepository usuariosRepository;
    private final PlayListsRepository playlistsRepository;
    private final UsersTokens usersTokens;
    private final PlayListService playListService;
    private static final Integer ID_USER_ADMIN_RANDOM_PLAYLIST = 8;

    public RandomPlaylistService(UsuariosRepository usuariosRepository, PlayListsRepository playlistsRepository, UsersTokens usersTokens, PlayListService playListService) {
        this.usuariosRepository = usuariosRepository;
        this.playlistsRepository = playlistsRepository;
        this.usersTokens = usersTokens;
        this.playListService = playListService;
    }

    private List<Playlist> getAllAdminPlaylists() {
        Usuario usuarioAdmin = usuariosRepository.findByid(ID_USER_ADMIN_RANDOM_PLAYLIST);
        return playlistsRepository.findByUserid(usuarioAdmin);
    }



}
