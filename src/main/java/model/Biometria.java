package model;

import java.time.LocalDate;

public class Biometria {
    private LocalDate data;
    private double pesoMedio;
    private double sobrevivencia;
    private double biomassa;

    public double calcularFCA(double racaoFornecida) {
        if (biomassa <= 0) return 0;
        return racaoFornecida / biomassa;
    }

    public Biometria() {
        this.data = LocalDate.now();
    }

    public Biometria(double pesoMedio, double sobrevivencia, double biomassa) {
        this.data = LocalDate.now();
        this.pesoMedio = pesoMedio;
        this.sobrevivencia = sobrevivencia;
        this.biomassa = biomassa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getPesoMedio() {
        return pesoMedio;
    }

    public void setPesoMedio(double pesoMedio) {
        this.pesoMedio = pesoMedio;
    }

    public double getSobrevivencia() {
        return sobrevivencia;
    }

    public void setSobrevivencia(double sobrevivencia) {
        this.sobrevivencia = sobrevivencia;
    }

    public double getBiomassa() {
        return biomassa;
    }

    public void setBiomassa(double biomassa) {
        this.biomassa = biomassa;
    }
}
