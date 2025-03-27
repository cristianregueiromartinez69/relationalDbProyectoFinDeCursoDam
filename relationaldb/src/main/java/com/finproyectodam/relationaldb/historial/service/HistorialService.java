package com.finproyectodam.relationaldb.historial.service;

import com.finproyectodam.relationaldb.excepciones.usuarios.LoginUserExcepcion;
import com.finproyectodam.relationaldb.model.dto.UsuarioDTO;
import com.finproyectodam.relationaldb.model.entitys.Usuario;
import com.finproyectodam.relationaldb.playlist.service.PlayListService;
import com.finproyectodam.relationaldb.usuarios.token.UsersTokens;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HistorialService {

    private final RedisTemplate<Integer, Object> redisTemplate;
    private final PlayListService playListService;
    private final UsersTokens usersTokens;


    public HistorialService(RedisTemplate<Integer, Object> redisTemplate, PlayListService playListService) {
        this.redisTemplate = redisTemplate;
        this.playListService = playListService;
        this.usersTokens = new UsersTokens();
    }

    public void saveSongHistorial(Integer idCancion) {
        Usuario usuario1 = playListService.getCurrentUser(usersTokens.getUserTokens());
        if (usuario1 == null) {
            throw new LoginUserExcepcion("Usuario no logueado, fuera hacker!!");
        }
        else{
            Integer idUsuario = usuario1.getId();
        }
    }

    private boolean checkLimitSongRedis(Integer idUsuario) {
        return redisTemplate.opsForList().size(idUsuario) < 10;
    }
}
