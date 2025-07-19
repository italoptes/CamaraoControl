package model;

import service.FazendaService;

public class MainTest {
    public static void main(String[] args) {
        FazendaService fazendaService = new FazendaService();


        //Criação fazenda
     Fazenda fazenda = new Fazenda();
     fazenda.setId(1);
     fazenda.setNome("Fazenda são Cosmo");
     fazenda.setLocalizacao("Pirpirituba");

     //Criação do viveiro
     Viveiro viveiro = new Viveiro();
     viveiro.setId(101);
     viveiro.setNome("V1");
     viveiro.setArea(500.0);
     // Adiciona o viveiro à fazenda
     fazenda.getViveiros().add(viveiro);


     //Qualidade de Água
     QualidadeAgua  qualidade = new QualidadeAgua();
     qualidade.setAmonia(0.3);
     qualidade.setNitrito(0.1);
     qualidade.setPh(7.8);
     qualidade.setAlcalinidade(120.0);
     qualidade.setSalinidade(25.0);
     qualidade.setOxigenio(6.5);
     //Relacionando qualidade águal com viveiro
     viveiro.getHistoricoQualidade().add(qualidade);

     // Biometria
     Biometria biometria = new Biometria();
     biometria.setPesoMedio(8.5);
     biometria.setSobrevivencia(95.0);
     biometria.setBiomassa(100.0);
     //Relacionando Biometria com viveiro
     viveiro.getHistoricoBiometria().add(biometria);

     // Consumo de Ração
     ConsumoRacao consumo = new ConsumoRacao();
     consumo.setQuantidade(12.0);
     consumo.setTipoRacao("Crescimento");
     //Relacionando Consumo com viveiro
     viveiro.getHistoricoConsumoRacao().add(consumo);

        // Salva a fazenda via service
        fazendaService.cadastraFazenda(fazenda);


        // Teste Básico
        System.out.println("📍 Fazenda: " + fazenda.getNome());
        for (Viveiro v : fazenda.getViveiros()) {
            System.out.println("  - Viveiro: " + v.getNome());

            System.out.println("    Qualidade da Água:");
            for (QualidadeAgua qa : v.getHistoricoQualidade()) {
                System.out.println("      pH: " + qa.getPh() + ", Oxigênio: " + qa.getOxigenio());
            }

            System.out.println("    Biometria:");
            for (Biometria b : v.getHistoricoBiometria()) {
                System.out.println("      Peso Médio: " + b.getPesoMedio() + "g, FCA: " + b.calcularFCA(consumo.getQuantidade()));
            }

            System.out.println("    Consumo de Ração:");
            for (ConsumoRacao c : v.getHistoricoConsumoRacao()) {
                System.out.println("      Tipo: " + c.getTipoRacao() + ", Quantidade: " + c.getQuantidade() + "kg");
            }
        }

    }
}
