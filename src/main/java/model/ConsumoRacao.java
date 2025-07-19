package model;

import java.time.LocalDate;

public class ConsumoRacao {
    private LocalDate data;
    private double quantidade;
    private String tipoRacao;

    public ConsumoRacao() {
        this.data = LocalDate.now();
    }

    public ConsumoRacao(double quantidade, String tipo) {
        this.data = LocalDate.now();
        this.quantidade = quantidade;
        this.tipoRacao = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoRacao() {
        return tipoRacao;
    }

    public void setTipoRacao(String tipoRacao) {
        this.tipoRacao = tipoRacao;
    }
}
