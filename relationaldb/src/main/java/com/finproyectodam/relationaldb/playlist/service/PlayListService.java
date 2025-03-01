package com.finproyectodam.relationaldb.playlist.service;

import com.finproyectodam.relationaldb.model.dto.PlaylistDTO;
import com.finproyectodam.relationaldb.model.entitys.Playlist;
import com.finproyectodam.relationaldb.model.entitys.Usuario;
import com.finproyectodam.relationaldb.repository.PlayListsRepository;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;



/**
 * Servicio de playlist
 * @author cristian && Joel
 */
@Service
public class PlayListService {

    //variable del repositorio
    private final PlayListsRepository playListsRepository;
    private final UsuariosRepository usersRepository;

    /**
     * Constructor de la clase
     * @param playListsRepository el repositorio de playlist
     */
    public PlayListService(PlayListsRepository playListsRepository, UsuariosRepository usersRepository) {
        this.playListsRepository = playListsRepository;
        this.usersRepository = usersRepository;
    }

    /**
     * Metodo para guardar una playlist
     * @param playlistDTO la playlist a guardar
     */
    public void savePlayList(PlaylistDTO playlistDTO) {
        Playlist playlist = new Playlist(playlistDTO.getTitulo(), playlistDTO.getFechacre(),
                playlistDTO.getDescrip(), getCurrentUser());

        playListsRepository.save(playlist);
    }

    private Usuario getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario;
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            usuario = usersRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            return usuario;
        } else {
            throw new RuntimeException("No se pudo obtener el usuario autenticado");
        }
    }





}
