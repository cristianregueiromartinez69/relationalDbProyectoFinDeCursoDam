package com.finproyectodam.relationaldb.usuarios.login.controller;

import com.finproyectodam.relationaldb.model.dto.UsuarioDTO;
import com.finproyectodam.relationaldb.usuarios.login.excepcion.LoginUserExcepcion;
import com.finproyectodam.relationaldb.usuarios.login.service.LoginUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relationaldb/spotify")
public class RestControllerLoginUsuarios {

    private final LoginUsuarioService loginusuarioService;

    public RestControllerLoginUsuarios(LoginUsuarioService loginusuarioService) {
        this.loginusuarioService = loginusuarioService;
    }

    @PostMapping("/loginusuarios")
    public ResponseEntity<String> loginUsuariosController(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            if (loginusuarioService.loginUser(usuarioDTO)) {
                return ResponseEntity.ok("Usuario logueado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
            }
        } catch (LoginUserExcepcion logE) {
            return new ResponseEntity<>(logE.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
