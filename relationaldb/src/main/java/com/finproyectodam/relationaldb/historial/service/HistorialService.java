package com.finproyectodam.relationaldb.historial.service;

import com.finproyectodam.relationaldb.excepciones.usuarios.LoginUserExcepcion;
import com.finproyectodam.relationaldb.model.entitys.Usuario;
import com.finproyectodam.relationaldb.playlist.service.PlayListService;
import com.finproyectodam.relationaldb.usuarios.token.UsersTokens;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Servicio de guardado de canciones en el historial
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class HistorialService {

    //atributos de clase
    private final RedisTemplate<Integer, Integer> redisTemplate;
    private final PlayListService playListService;
    private final UsersTokens usersTokens;

    /**
     * Constructor de la clase
     * @param redisTemplate el servicio de redis
     * @param playListService el servicio de playlist
     */
    public HistorialService(RedisTemplate<Integer, Integer> redisTemplate, PlayListService playListService) {
        this.redisTemplate = redisTemplate;
        this.playListService = playListService;
        this.usersTokens = new UsersTokens();
    }

    /**
     * Metodo que guarda el historial de una cancion en redis
     * @param idCancion el id de la cancion
     */
    public void saveSongHistorial(Integer idCancion) {
        Usuario usuario1 = playListService.getCurrentUser(usersTokens.getUserTokens());
        if (usuario1 == null) {
            throw new LoginUserExcepcion("Usuario no logueado, fuera hacker!!");
        }
        else{
            Integer idUsuario = usuario1.getId();
            if(checkLimitSongRedis(idUsuario)) {
                redisTemplate.opsForList().remove(idUsuario, 1, idCancion);
                redisTemplate.opsForList().leftPush(idUsuario, idCancion);
            }
        }
    }

    /**
     * Metodo para comprobar si tienes más de 10 canciones en el historial
     * @param idUsuario el id del usuario que es la clave
     * @return true o false dependiendo de si lo superas o no
     */
    private boolean checkLimitSongRedis(Integer idUsuario) {
        Long size = redisTemplate.opsForList().size(idUsuario);
        return size != null && size < 10;
    }
}
