package com.finproyectodam.relationaldb.usuarios.interfaces;

import com.finproyectodam.relationaldb.model.dto.UsuarioDTO;

import java.net.http.HttpHeaders;

public interface LoggedInterface {

    UsuarioDTO getLoguedUser(HttpHeaders headers);
}
