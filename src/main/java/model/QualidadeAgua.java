package model;

import java.time.LocalDate;

public class QualidadeAgua {
    private LocalDate data;
    private double amonia;
    private double nitrito;
    private double ph;
    private double alcalinidade;
    private double salinidade;
    private double oxigenio;

    public QualidadeAgua() {
        this.data = LocalDate.now();
    }

    public QualidadeAgua(double amonia, double nitrito, double ph, double alcalinidade, double salinidade, double oxigenio) {
        this.data = LocalDate.now();
        this.amonia = amonia;
        this.nitrito = nitrito;
        this.ph = ph;
        this.alcalinidade = alcalinidade;
        this.salinidade = salinidade;
        this.oxigenio = oxigenio;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getAmonia() {
        return amonia;
    }

    public void setAmonia(double amonia) {
        this.amonia = amonia;
    }

    public double getNitrito() {
        return nitrito;
    }

    public void setNitrito(double nitrito) {
        this.nitrito = nitrito;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getAlcalinidade() {
        return alcalinidade;
    }

    public void setAlcalinidade(double alcalinidade) {
        this.alcalinidade = alcalinidade;
    }

    public double getSalinidade() {
        return salinidade;
    }

    public void setSalinidade(double salinidade) {
        this.salinidade = salinidade;
    }

    public double getOxigenio() {
        return oxigenio;
    }

    public void setOxigenio(double oxigenio) {
        this.oxigenio = oxigenio;
    }
}
