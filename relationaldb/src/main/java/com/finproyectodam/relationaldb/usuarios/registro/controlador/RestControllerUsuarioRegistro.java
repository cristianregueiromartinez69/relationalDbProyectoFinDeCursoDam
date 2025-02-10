package com.finproyectodam.relationaldb.usuarios.registro.controlador;

import com.finproyectodam.relationaldb.model.dto.UsuarioDTO;
import com.finproyectodam.relationaldb.usuarios.registro.servicio.UsuarioregistroServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relationaldb/spotify")
public class RestControllerUsuarioRegistro {

    private final UsuarioregistroServicio usuarioregistroServicio;

    public RestControllerUsuarioRegistro(UsuarioregistroServicio usuarioregistroServicio) {
        this.usuarioregistroServicio = usuarioregistroServicio;
    }

    @PostMapping("/registrousuarios")
    public ResponseEntity<String> registroUsuariosController(UsuarioDTO usuarioDTO) {
        try{
            usuarioregistroServicio.registroUsuario(usuarioDTO);
            return ResponseEntity.ok("usuario registrado exitosamente");
        }catch (Exception e){
            return new ResponseEntity<>("Ups, ha ocurrido un error a la hora de realizar el registro", HttpStatus.BAD_REQUEST);
        }
    }
}
