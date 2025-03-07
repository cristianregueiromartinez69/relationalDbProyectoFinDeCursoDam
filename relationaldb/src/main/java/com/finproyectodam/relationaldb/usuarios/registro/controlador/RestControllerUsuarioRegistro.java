package com.finproyectodam.relationaldb.usuarios.registro.controlador;

import com.finproyectodam.relationaldb.excepciones.usuarios.RegistroException;
import com.finproyectodam.relationaldb.model.dto.UsuarioDTO;
import com.finproyectodam.relationaldb.usuarios.registro.servicio.UsuarioregistroServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * restController de la clase para registrar a los usuarios
 * @author cristian && Joel
 * version 1.0
 */
@RestController
@RequestMapping("/relationaldb/spotify")
public class RestControllerUsuarioRegistro {

    private final UsuarioregistroServicio usuarioregistroServicio;

    /**
     * constructor de la clase que inyecta las dependencias del servicio
     * @param usuarioregistroServicio el servicio de registro
     */
    public RestControllerUsuarioRegistro(UsuarioregistroServicio usuarioregistroServicio) {
        this.usuarioregistroServicio = usuarioregistroServicio;
    }

    /**
     * Restcontroller que manda al usuario registrado a la base de datos
     * @param usuarioDTO el usuario a registrar
     * @return mensaje descriptivo segun el resultado
     */
    @PostMapping("/registrousuarios")
    public ResponseEntity<String> registroUsuariosController(@RequestBody UsuarioDTO usuarioDTO) {
        try{
            usuarioregistroServicio.registroUsuario(usuarioDTO);
            return ResponseEntity.ok("usuario registrado exitosamente");

        }catch (RegistroException re){
            return new ResponseEntity<>(re.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>("Ups, ha ocurrido un error a la hora de realizar el registro", HttpStatus.BAD_REQUEST);
        }
    }
}
