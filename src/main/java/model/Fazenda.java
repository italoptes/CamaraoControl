package model;

import java.util.ArrayList;
import java.util.Objects;

public class Fazenda {
    private int id;
    private String nome;
    private String localizacao;

    private ArrayList<Viveiro> viveiros;

    public Fazenda() {
        this.viveiros = new ArrayList<>();
    }

    public Fazenda(int id, String nome, String localizacao) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.viveiros = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public ArrayList<Viveiro> getViveiros() {
        return viveiros;
    }

    public void setViveiros(ArrayList<Viveiro> viveiros) {
        this.viveiros = viveiros;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fazenda fazenda = (Fazenda) o;
        return id == fazenda.id && Objects.equals(nome, fazenda.nome) && Objects.equals(localizacao, fazenda.localizacao) && Objects.equals(viveiros, fazenda.viveiros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, localizacao, viveiros);
    }
}
