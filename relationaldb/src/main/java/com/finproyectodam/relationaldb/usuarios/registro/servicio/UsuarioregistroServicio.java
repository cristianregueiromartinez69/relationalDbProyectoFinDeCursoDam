package com.finproyectodam.relationaldb.usuarios.registro.servicio;

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
        Usuario usuario = new Usuario(usuarioDTO.getUsername(), usuarioDTO.getEmail(), usuarioDTO.getPasswordU(), usuarioDTO.getDateReg());
        usuariosRepository.save(usuario);
    }
}
