package com.finproyectodam.relationaldb.usuarios.login.controller;

import com.finproyectodam.relationaldb.model.dto.UsuarioDTO;
import com.finproyectodam.relationaldb.excepciones.usuarios.LoginUserExcepcion;
import com.finproyectodam.relationaldb.usuarios.login.service.LoginUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController de login de usuarios
 * @author cristian && Joel
 * @version 1.0
 */
@RestController
@RequestMapping("/relationaldb/spotify")
public class RestControllerLoginUsuarios {

    private final LoginUsuarioService loginusuarioService;

    /**
     * Constructor de la clase
     * @param loginusuarioService el login de los usuarios
     */
    public RestControllerLoginUsuarios(LoginUsuarioService loginusuarioService) {
        this.loginusuarioService = loginusuarioService;
    }

    /**
     * metodo post que envía la información de vuelta al external datos con la confirmacion o negacion de login de usuario
     * @param usuarioDTO el objeto de login de usuario
     * @return confirmacion o negacion dependiendo de si hubo o no éxtio
     */
    @PostMapping("/loginusuarios")
    public ResponseEntity<String> loginUsuariosController(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            if (loginusuarioService.loginUser(usuarioDTO)) {
                return ResponseEntity.ok("Usuario logueado correctamente ");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
            }
        } catch (LoginUserExcepcion logE) {
            return new ResponseEntity<>(logE.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
