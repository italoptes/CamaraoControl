package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Usuario;

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

public class UsuarioRepository {

    private final String jsonPath;
    private static final String DEFAULT_JSON_PATH = "src/main/resources/json/Usuario.json";
    private final Map<String, Usuario> usuarios = new HashMap<>();

    public UsuarioRepository() {
        this(DEFAULT_JSON_PATH);
    }

    public UsuarioRepository(String jsonPath) {
        this.jsonPath = jsonPath;
        carregarUsuarios();
    }

    private void carregarUsuarios() {
        usuarios.clear();
        Path path = Paths.get(jsonPath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao criar arquivo de usuários.", e);
            }
            return;
        }

        try (FileReader reader = new FileReader(jsonPath)) {
            Gson gson = new Gson();
            Type tipoListaUsuario = new TypeToken<List<Usuario>>() {}.getType();
            List<Usuario> listaUsuario = gson.fromJson(reader, tipoListaUsuario);
            if (listaUsuario != null) {
                for (Usuario usuario : listaUsuario) {
                    usuarios.put(usuario.getId(), usuario);
                }
            } else {
                System.err.println("A lista de usuários está vazia ou não foi deserializada corretamente.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler arquivo de usuários.", e);
        }
    }

    public void salvarUsuario(Usuario usuario) {
        if (usuario == null || usuario.getId() == null || usuario.getLogin() == null) {
            throw new IllegalArgumentException("Usuário ou campos obrigatórios nulos.");
        }
        carregarUsuarios();
        usuarios.put(usuario.getId(), usuario);
        salvarUsuarios();
    }

    private void salvarUsuarios() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(jsonPath))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(new ArrayList<>(usuarios.values()));
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar usuários.", e);
        }
    }

    public void removerUsuario(String id) {
        carregarUsuarios();
        usuarios.remove(id);
        salvarUsuarios();
    }

    public List<Usuario> listarUsuarios() {
        carregarUsuarios();
        return new ArrayList<>(usuarios.values());
    }

    public Usuario buscarUsuarioPorLogin(String login) {
        carregarUsuarios();
        return usuarios.values().stream()
                .filter(u -> login.equals(u.getLogin()))
                .findFirst()
                .orElse(null);
    }

    public boolean existeUsuario(String id) {
        carregarUsuarios();
        return usuarios.containsKey(id);
    }
}