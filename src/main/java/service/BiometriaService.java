package service;

import model.Biometria;
import model.Fazenda;
import model.Viveiro;

import java.util.List;

public class BiometriaService {
    private final FazendaService fazendaService;

    public BiometriaService(FazendaService fazendaService) {
        this.fazendaService = fazendaService;
    }

    public void adicionarBiometria(int fazendaId, int viveiroId, Biometria biometria) {
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
        if (biometria.getBiomassa() <= 0) {
            throw new IllegalArgumentException("Biomassa deve ser maior que 0.");
        }
        viveiro.getHistoricoBiometria().add(biometria);
        fazendaService.cadastraFazenda(fazenda);
    }

    public List<Biometria> listarBiometriasDoViveiro(int fazendaId, int viveiroId) {
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
        return viveiro.getHistoricoBiometria();
    }

}
