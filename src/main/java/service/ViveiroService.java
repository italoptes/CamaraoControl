package service;

import model.Fazenda;
import model.Viveiro;

import java.util.List;

public class ViveiroService {
    private final FazendaService fazendaService;

    public ViveiroService(FazendaService fazendaService) {
        this.fazendaService = fazendaService;
    }

    public void adicionaViveiro(int fazendaId, Viveiro viveiro) {
        Fazenda fazenda = fazendaService.buscarFazendaPorId(fazendaId);
        if (fazenda == null) {
            throw new IllegalArgumentException("Fazenda não encontrada para o ID: " + fazendaId);
        }
        // Verifica se já existe viveiro com mesmo ID
        boolean existe = fazenda.getViveiros().stream()
                .anyMatch(v -> v.getId() == viveiro.getId());
        if (existe) {
            throw new IllegalArgumentException("Já existe um viveiro com esse ID na fazenda.");
        }
        fazenda.getViveiros().add(viveiro);
        fazendaService.cadastraFazenda(fazenda); //salva a mudança
    }

    public List<Viveiro> listaViveirosDaFazenda(int fazendaId) {
        Fazenda fazenda = fazendaService.buscarFazendaPorId(fazendaId);
        if (fazenda == null) {
            throw new IllegalArgumentException("Fazenda não encontrada.");
        }
        return fazenda.getViveiros();
    }

    public Viveiro buscarViveiroNaFazenda(int fazendaId, int viveiroId) {
        Fazenda fazenda = fazendaService.buscarFazendaPorId(fazendaId);
        if (fazenda == null) {
            throw new IllegalArgumentException("Fazenda não encontrada.");
        }
        return fazenda.getViveiros().stream()
                .filter(v -> v.getId() == viveiroId)
                .findFirst()
                .orElse(null);
    }

    public void removerViveiro(int fazendaId, int viveiroId) {
        Fazenda fazenda = fazendaService.buscarFazendaPorId(fazendaId);
        if (fazenda == null) {
            throw new IllegalArgumentException("Fazenda não encontrada.");
        }
        boolean removido = fazenda.getViveiros().removeIf(v -> v.getId() == viveiroId);
        if (removido) {
            fazendaService.cadastraFazenda(fazenda); // atualiza persistência
        } else {
            throw new IllegalArgumentException("Viveiro não encontrado.");
        }
    }
}
