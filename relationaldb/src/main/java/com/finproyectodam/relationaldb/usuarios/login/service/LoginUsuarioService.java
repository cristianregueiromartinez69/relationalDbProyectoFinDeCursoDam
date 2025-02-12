package com.finproyectodam.relationaldb.usuarios.login.service;

import com.finproyectodam.relationaldb.model.dto.UsuarioDTO;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import com.finproyectodam.relationaldb.excepciones.usuarios.LoginUserExcepcion;
import org.springframework.stereotype.Service;

/**
 * Servicio de login de usuarios
 * @author cristian && Joel
 * @version 1.0
 */
@Service
public class LoginUsuarioService {

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

}
