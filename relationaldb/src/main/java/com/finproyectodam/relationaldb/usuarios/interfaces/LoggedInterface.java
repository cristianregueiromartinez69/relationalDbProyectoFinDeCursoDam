package com.finproyectodam.relationaldb.usuarios.interfaces;

import com.finproyectodam.relationaldb.model.entitys.Usuario;

import java.net.http.HttpHeaders;

public interface LoggedInterface {

    Usuario getLoguedUser(HttpHeaders headers);
}
