package com.finproyectodam.relationaldb.usuarios.login.service;

import com.finproyectodam.relationaldb.excepciones.usuarios.NotFoundException;
import com.finproyectodam.relationaldb.model.dto.UsuarioDTO;
import com.finproyectodam.relationaldb.model.entitys.Usuario;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import com.finproyectodam.relationaldb.excepciones.usuarios.LoginUserExcepcion;
import com.finproyectodam.relationaldb.usuarios.interfaces.LoggedInterface;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.net.http.HttpHeaders;

/**
 * Servicio de login de usuarios
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class LoginUsuarioService implements LoggedInterface {

    private final UsuariosRepository usuariosRepository;

    /**
     * Constructor de la clase
     * @param usuariosRepository el repositorio de usuarios
     */
    public LoginUsuarioService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    /**
     * Metodo que comprueba si el email o la contraseña existen en la base de datos
     * @param usuarioDTO el objeto login de usuario
     * @return true o false dependiendo de si existe o no
     */
    public boolean loginUser(UsuarioDTO usuarioDTO){
        if(!checkExistsEmail(usuarioDTO.getEmail())){
            throw new LoginUserExcepcion("Email no encontrado, vuelve a escribirlo");
        }
        if(!checkExistsPassword(usuarioDTO.getPasswordU())){
            throw new LoginUserExcepcion("Contraseña no encontrada, vuelve a escribirla");
        }
        return true;
    }

    /**
     * metodo que comprueba si el email existe en la base de datos
     * @param email el email del usuario
     * @return true o false dependiendo de si existe o no
     */
    public boolean checkExistsEmail(String email){
        return usuariosRepository.findByEmail(email).isPresent();
    }

    /**
     * metodo que comprueba si la contraseña existe en la base de datos
     * @param password la contraseña del usuario
     * @return true o false dependiendo de si existe o no
     */
    public boolean checkExistsPassword(String password){
        return usuariosRepository.findByPasswordU(password).isPresent();
    }

    @Override
    public Usuario getLoguedUser(HttpHeaders headers) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = ((Usuario) authentication.getPrincipal()).getEmail();

        return usuariosRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
    }

}
