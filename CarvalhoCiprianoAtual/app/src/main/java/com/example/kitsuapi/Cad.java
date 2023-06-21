package com.example.kitsuapi;

public class Cad {
    private String nome;
    private String email;
    private String senha;

public Cad(String _nome, String _senha, String _email) {
        this.nome = _nome;
        this.email = _email;
        this.senha = _senha;
    }

    public String get_nome(){
        return nome;
    }

    public String get_email(){
        return email;
    }

    public String get_senha(){
        return senha;
    }

    public void set_nome(String nome){
        this.nome = nome;
    }

    public void set_email(String email){
        this.email = email;
    }

    public void set_senha(String senha){
        this.senha = senha;
    }
}
