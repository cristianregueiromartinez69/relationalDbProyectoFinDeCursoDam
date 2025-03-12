package com.finproyectodam.relationaldb.randomplaylist.service;

import com.finproyectodam.relationaldb.repository.PlayListsRepository;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import com.finproyectodam.relationaldb.usuarios.token.UsersTokens;
import org.springframework.stereotype.Service;

@Service
public class RandomPlaylistService {

    private final UsuariosRepository usuariosRepository;
    private final PlayListsRepository playlistsRepository;
    private final UsersTokens usersTokens;

    public RandomPlaylistService(UsuariosRepository usuariosRepository, PlayListsRepository playlistsRepository, UsersTokens usersTokens) {
        this.usuariosRepository = usuariosRepository;
        this.playlistsRepository = playlistsRepository;
        this.usersTokens = usersTokens;
    }


}
