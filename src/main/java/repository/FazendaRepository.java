package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Fazenda;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FazendaRepository {
    private final String jsonPath;
    private static final String DEFAULT_JSON_PATH = "src/main/resources/json/Fazenda.json";
    private final Map<Integer, Fazenda> fazendas = new HashMap<>();

    public FazendaRepository() {
        this(DEFAULT_JSON_PATH);
    }

    public FazendaRepository(String jsonPath) {
        this.jsonPath = jsonPath;
        carregarFazendas();
    }

    private void carregarFazendas() {
        fazendas.clear();
        Path path = Paths.get(jsonPath); //modificar para jsonPath
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao criar arquivo de fazendas.", e);
            }
            return;
        }
        try (FileReader reader = new FileReader(jsonPath)) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(java.time.LocalDate.class, new util.LocalDateAdapter())
                    .create();
            Type tipoListaFazenda = new TypeToken<List<Fazenda>>(){}.getType();
            List<Fazenda> listaFazenda = gson.fromJson(reader, tipoListaFazenda);
            if (listaFazenda != null) {
                for (Fazenda fazenda : listaFazenda) {
                    fazendas.put(fazenda.getId(), fazenda);
                }
            } else {
                // Caso a lista seja null, você pode adicionar um comportamento alternativo
                System.err.println("A lista de fazendas está vazia ou não foi deserializada corretamente.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler arquivo de fazendas.", e);
        }
    }

    public void salvarFazenda(Fazenda fazenda) {
        if (fazenda == null) {
            throw new IllegalArgumentException("Fazenda ou campos obrigatórios nulos.");
        }
        carregarFazendas();
        fazendas.put(fazenda.getId(), fazenda);
        salvarFazendas();
    }

    private void salvarFazendas() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(jsonPath))) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(java.time.LocalDate.class, new util.LocalDateAdapter())
                    .create();// formata o arquivo para o modelo json
            String json = gson.toJson(new ArrayList<>(fazendas.values()));// cria uma string com todos os dados de usuarios
            writer.write(json);//escreve todos os usuarios em um arquivo formato json
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar fazendas.", e);
        }
    }

    public void removerFazenda(Integer id) {
        carregarFazendas();
        fazendas.remove(id);
        salvarFazendas();
    }

    public List<Fazenda> listarFazendas() {
        carregarFazendas();
        return new ArrayList<>(fazendas.values());
    }

    public Fazenda buscarFazendasPorId(Integer id) {
        carregarFazendas();
        return fazendas.get(id);
    }

    public boolean existeFazenda(int id) {
        carregarFazendas();
        return fazendas.containsKey(id);
    }
}
