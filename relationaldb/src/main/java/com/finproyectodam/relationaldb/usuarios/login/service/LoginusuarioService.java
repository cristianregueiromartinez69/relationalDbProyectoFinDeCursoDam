package com.finproyectodam.relationaldb.usuarios.login.service;

import com.finproyectodam.relationaldb.model.dto.UsuarioDTO;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginusuarioService {

    private final UsuariosRepository usuariosRepository;

    public LoginusuarioService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public void loginUser(UsuarioDTO usuarioDTO){
        if(!checkExistsEmail(usuarioDTO.getEmail())){

        }
    }

    public boolean checkExistsEmail(String email){
        return usuariosRepository.findByEmail(email).isPresent();
    }

    public boolean checkExistsPassword(String password){
        return usuariosRepository.findByPasswordU(password).isPresent();
    }

}
