package model;

import java.time.LocalDate;

public class EstoqueRacao {
    private Long id;
    private String tipoRacao;
    private double quantidadeKg;
    private LocalDate dataAtualizacao;

    public EstoqueRacao() {
    }

    public EstoqueRacao(Long id, String tipo, double quantidadeKg, LocalDate dataAtualizacao) {
        this.id = id;
        this.tipoRacao = tipo;
        this.quantidadeKg = quantidadeKg;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoRacao() {
        return tipoRacao;
    }

    public void setTipoRacao(String tipoRacao) {
        this.tipoRacao = tipoRacao;
    }

    public double getQuantidadeKg() {
        return quantidadeKg;
    }

    public void setQuantidadeKg(double quantidadeKg) {
        this.quantidadeKg = quantidadeKg;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
