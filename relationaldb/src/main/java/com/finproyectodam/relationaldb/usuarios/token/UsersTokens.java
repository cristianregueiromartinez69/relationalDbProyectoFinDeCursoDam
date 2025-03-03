package com.finproyectodam.relationaldb.usuarios.token;

import com.finproyectodam.relationaldb.model.entitys.Usuario;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class UsersTokens {

    private final HashMap<Usuario, String> usersLoggin;

    public UsersTokens() {
        usersLoggin = new HashMap<>();
    }

    public void putUsersLogin(Usuario usuario, String token) {
        usersLoggin.put(usuario, token);
    }

    public void deleteUsersLogin(Usuario usuario) {
        usersLoggin.remove(usuario);
    }

    public HashMap<Usuario, String> getUsersLogin() {
        return usersLoggin;
    }
}
