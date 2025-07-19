package service;

import model.Fazenda;
import model.QualidadeAgua;
import model.Viveiro;

import java.util.List;

public class QualidadeAguaService {
    private final FazendaService fazendaService;

    public QualidadeAguaService(FazendaService fazendaService) {
        this.fazendaService = fazendaService;
    }

    public void adicionarQualidadeAgua(int fazendaId, int viveiroId, QualidadeAgua qualidade) {
        Fazenda fazenda = fazendaService.buscarFazendaPorId(fazendaId);
        if (fazenda == null) {
            throw new IllegalArgumentException("Fazenda não encontrada.");
        }

        Viveiro viveiro = fazenda.getViveiros().stream()
                .filter(v -> v.getId() == viveiroId)
                .findFirst()
                .orElse(null);

        if (viveiro == null) {
            throw new IllegalArgumentException("Viveiro não encontrado.");
        }

        viveiro.getHistoricoQualidade().add(qualidade);
        fazendaService.cadastraFazenda(fazenda); // salva tudo de novo
    }

    public List<QualidadeAgua> listarQualidadePorViveiro(int fazendaId, int viveiroId) {
        Fazenda fazenda = fazendaService.buscarFazendaPorId(fazendaId);
        if (fazenda == null) {
            throw new IllegalArgumentException("Fazenda não encontrada.");
        }

        Viveiro viveiro = fazenda.getViveiros().stream()
                .filter(v -> v.getId() == viveiroId)
                .findFirst()
                .orElse(null);

        if (viveiro == null) {
            throw new IllegalArgumentException("Viveiro não encontrado.");
        }

        return viveiro.getHistoricoQualidade();
    }
}
