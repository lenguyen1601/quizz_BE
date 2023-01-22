package com.example.quizz_backend.model;

public class JwtReponse {
    String token;

    public JwtReponse(String token) {
        this.token = token;
    }

    public JwtReponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
