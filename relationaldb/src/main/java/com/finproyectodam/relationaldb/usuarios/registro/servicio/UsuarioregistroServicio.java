package com.finproyectodam.relationaldb.usuarios.registro.servicio;

import com.finproyectodam.relationaldb.excepciones.usuarios.RegistroException;
import com.finproyectodam.relationaldb.model.dto.UsuarioDTO;
import com.finproyectodam.relationaldb.model.entitys.Usuario;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioregistroServicio {

    private final UsuariosRepository usuariosRepository;

    public UsuarioregistroServicio(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public void registroUsuario(UsuarioDTO usuarioDTO) {

        if(usuariosRepository.findByUsername(usuarioDTO.getUsername()).isPresent()){
            throw new RegistroException("EL alias ya existe, escoge otro");
        }
        if(usuariosRepository.findByEmail(usuarioDTO.getEmail()).isPresent()){
            throw new RegistroException("EL email ya existe, escoge otro");
        }
        Usuario usuario = new Usuario(usuarioDTO.getUsername(), usuarioDTO.getEmail(), usuarioDTO.getPasswordU(), usuarioDTO.getDateReg());
        usuariosRepository.save(usuario);
    }
}
