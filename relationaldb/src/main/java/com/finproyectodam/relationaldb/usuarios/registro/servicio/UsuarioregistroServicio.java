package com.finproyectodam.relationaldb.usuarios.registro.servicio;

import com.finproyectodam.relationaldb.excepciones.usuarios.RegistroException;
import com.finproyectodam.relationaldb.model.dto.UsuarioDTO;
import com.finproyectodam.relationaldb.model.entitys.Usuario;
import com.finproyectodam.relationaldb.repository.UsuariosRepository;
import org.springframework.stereotype.Service;


/**
 * Clase servicio para realizar la logica del registro de usuarios
 * @author cristian && Joel
 * version 1.0
 */
@Service
public class UsuarioregistroServicio {

    private final UsuariosRepository usuariosRepository;

    /**
     * constructor que inyecta dependencias del repositorio de usuarios
     * @param usuariosRepository
     */
    public UsuarioregistroServicio(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    /**
     * Metodo para registrar usuarios en la base de datos
     * @param usuarioDTO el usuario a registrar
     */
    public void registroUsuario(UsuarioDTO usuarioDTO) {

        //comprobamos si el email o alias ya existen
        if(usuariosRepository.findByUsername(usuarioDTO.getUsername()).isPresent()){
            throw new RegistroException("EL alias ya existe, escoge otro");
        }
        if(usuariosRepository.findByEmail(usuarioDTO.getEmail()).isPresent()){
            throw new RegistroException("EL email ya existe, escoge otro");
        }

        //si va bien,se registra al usuario
        Usuario usuario = new Usuario(usuarioDTO.getUsername(), usuarioDTO.getEmail(), usuarioDTO.getPasswordU(), usuarioDTO.getDateReg());
        usuariosRepository.save(usuario);
    }
}
