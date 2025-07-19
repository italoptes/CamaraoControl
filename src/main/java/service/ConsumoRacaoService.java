package service;

import model.ConsumoRacao;
import model.Fazenda;
import model.Viveiro;

import java.util.List;

public class ConsumoRacaoService {
    private final FazendaService fazendaService;

    public ConsumoRacaoService(FazendaService fazendaService) {
        this.fazendaService = fazendaService;
    }

    public void adicionarConsumoRacao(int fazendaId, int viveiroId, ConsumoRacao consumo) {
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
        if (consumo.getQuantidade() <= 0) {
            throw new IllegalArgumentException("Quantidade de ração inválida.");
        }

        viveiro.getHistoricoConsumoRacao().add(consumo);
        fazendaService.cadastraFazenda(fazenda);
    }

    public List<ConsumoRacao> listarConsumoPorViveiro(int fazendaId, int viveiroId) {
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

        return viveiro.getHistoricoConsumoRacao();
    }
}
