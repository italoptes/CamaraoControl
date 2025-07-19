package model;

import java.util.ArrayList;

public class Viveiro {
    private int id;
    private String nome;
    private double area;
    private ArrayList<QualidadeAgua> historicoQualidade;
    private ArrayList<Biometria> historicoBiometria;
    private ArrayList<ConsumoRacao> historicoConsumoRacao;

    public Viveiro() {
        this.historicoQualidade = new ArrayList<>();
        this.historicoBiometria = new ArrayList<>();
        this.historicoConsumoRacao = new ArrayList<>();
    }

    public Viveiro(int id, String nome, double area) {
        this.id = id;
        this.nome = nome;
        this.area = area;
        this.historicoQualidade = new ArrayList<>();
        this.historicoBiometria = new ArrayList<>();
        this.historicoConsumoRacao = new ArrayList<>();
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public ArrayList<QualidadeAgua> getHistoricoQualidade() {
        return historicoQualidade;
    }

    public void setHistoricoQualidade(ArrayList<QualidadeAgua> historicoQualidade) {
        this.historicoQualidade = historicoQualidade;
    }

    public ArrayList<Biometria> getHistoricoBiometria() {
        return historicoBiometria;
    }

    public void setHistoricoBiometria(ArrayList<Biometria> historicoBiometria) {
        this.historicoBiometria = historicoBiometria;
    }

    public ArrayList<ConsumoRacao> getHistoricoConsumoRacao() {
        return historicoConsumoRacao;
    }

    public void setHistoricoConsumoRacao(ArrayList<ConsumoRacao> historicoConsumoRacao) {
        this.historicoConsumoRacao = historicoConsumoRacao;
    }
}
