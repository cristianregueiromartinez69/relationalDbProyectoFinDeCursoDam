package com.finproyectodam.relationaldb.usuarios.login.service;

import com.finproyectodam.relationaldb.model.dto.UsuarioDTO;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import com.finproyectodam.relationaldb.usuarios.login.excepcion.LoginUserExcepcion;
import org.springframework.stereotype.Service;


@Service
public class LoginUsuarioService {

    private final UsuariosRepository usuariosRepository;

    public LoginUsuarioService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public boolean loginUser(UsuarioDTO usuarioDTO){
        if(!checkExistsEmail(usuarioDTO.getEmail())){
            throw new LoginUserExcepcion("Email no encontrado, vuelve a escribirlo");
        }
        if(!checkExistsPassword(usuarioDTO.getPasswordU())){
            throw new LoginUserExcepcion("Contraseña no encontrada, vuelve a escribirla");
        }
        return true;
    }

    public boolean checkExistsEmail(String email){
        return usuariosRepository.findByEmail(email).isPresent();
    }

    public boolean checkExistsPassword(String password){
        return usuariosRepository.findByPasswordU(password).isPresent();
    }

}
