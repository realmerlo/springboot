package com.example.es2;

public class User {
    private String nome;
    private String provincia;

    private String saluto;

    public User(String nome, String provincia) {
        this.nome = nome;
        this.provincia = provincia;
        this.saluto = "Ciao " + nome + ", com'è il tempo in " + provincia + " ?";
    }
}
