package com.finproyectodam.relationaldb.usuarios.token;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class UsersTokens {
    // Mapa concurrente para almacenar tokens de usuarios
    private final ConcurrentHashMap<String, String> userTokens;

    public UsersTokens() {
        userTokens = new ConcurrentHashMap<>();
    }

    public void putUserToken(String email, String token) {
        userTokens.put(email, token);
    }

    public String getUserToken(String email) {
        return userTokens.get(email);
    }

    public void removeUserToken(String email) {
        userTokens.remove(email);
    }
}

}
