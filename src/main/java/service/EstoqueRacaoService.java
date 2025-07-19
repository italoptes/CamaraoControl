package service;

import model.EstoqueRacao;
import model.Fazenda;

import java.util.List;

public class EstoqueRacaoService {
    private final FazendaService fazendaService;

    public EstoqueRacaoService(FazendaService fazendaService) {
        this.fazendaService = fazendaService;
    }

    public void adicionarEstoque(int fazendaId, EstoqueRacao novoEstoque) {
        Fazenda fazenda = fazendaService.buscarFazendaPorId(fazendaId);
        if (fazenda == null) {
            throw new IllegalArgumentException("Fazenda não encontrada.");
        }
        if (novoEstoque.getQuantidadeKg() <= 0) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }

        fazenda.getEstoqueRacao().add(novoEstoque);
        fazendaService.cadastraFazenda(fazenda);
    }

    public List<EstoqueRacao> listarEstoque(int fazendaId) {
        Fazenda fazenda = fazendaService.buscarFazendaPorId(fazendaId);
        if (fazenda == null) {
            throw new IllegalArgumentException("Fazenda não encontrada.");
        }

        return fazenda.getEstoqueRacao();
    }

    public double calcularTotalPorTipo(int fazendaId, String tipo) {
        Fazenda fazenda = fazendaService.buscarFazendaPorId(fazendaId);
        if (fazenda == null) {
            throw new IllegalArgumentException("Fazenda não encontrada.");
        }

        return fazenda.getEstoqueRacao().stream()
                .filter(e -> e.getTipoRacao().equalsIgnoreCase(tipo))
                .mapToDouble(EstoqueRacao::getQuantidadeKg)
                .sum();
    }
}
