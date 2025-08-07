package model;

import java.util.ArrayList;

public class Usuario {
    private String id;
    private String login;
    private String nome;
    private String senha;
    private ArrayList<Fazenda> fazendas;



    public Usuario(String login, String nome, String senha) {
        this.id = java.util.UUID.randomUUID().toString();
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.fazendas = new ArrayList<>();
    }

    public Usuario() {
        this.fazendas = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Fazenda> getFazendas() {
        return fazendas;
    }

    public void setFazendas(ArrayList<Fazenda> fazendas) {
        this.fazendas = fazendas;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
