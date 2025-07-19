package service;

import model.Fazenda;
import repository.FazendaRepository;

import java.util.List;

public class FazendaService {
    private final FazendaRepository fazendaRepository;

    public FazendaService() {
        this.fazendaRepository = new FazendaRepository();
    }

    public void cadastraFazenda(Fazenda fazenda) {
        if (fazenda == null ) {
            throw new IllegalArgumentException("Fazenda inválida.");
        }
        if (fazendaRepository.existeFazenda(fazenda.getId())) {
            throw new IllegalArgumentException("Já existe uma fazenda com esse ID.");
        }
        fazendaRepository.salvarFazenda(fazenda);
    }

    public List<Fazenda> listarFazendas() {
        return fazendaRepository.listarFazendas();
    }

    public void removerFazenda(Integer id) {
        if (id == null || !fazendaRepository.existeFazenda(id)) {
            throw new IllegalArgumentException("Fazenda inválida ou não encontrada.");
        }
        fazendaRepository.removerFazenda(id);
    }

    public Fazenda buscarFazendaPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id inválida.");
        }
        return fazendaRepository.buscarFazendasPorId(id);
    }
}
