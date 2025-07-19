package service;

import model.Usuario;
import repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (usuario == null || usuario.getLogin() == null || usuario.getSenha() == null) {
            throw new IllegalArgumentException("Usuário inválido ou sem login/senha.");
        }
        if (usuarioRepository.buscarUsuarioPorLogin(usuario.getLogin()) != null) {
            throw new IllegalArgumentException("Login já está em uso.");
        }
        usuarioRepository.salvarUsuario(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

    public void removerUsuario(String id) {
        if (id == null || !usuarioRepository.existeUsuario(id)) {
            throw new IllegalArgumentException("Usuário inválido ou não encontrado.");
        }
        usuarioRepository.removerUsuario(id);
    }

    public Usuario buscarUsuarioPorLogin(String login) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Login inválido.");
        }
        return usuarioRepository.buscarUsuarioPorLogin(login);
    }

    public Usuario autenticar(String login, String senha) {
        Usuario usuario = buscarUsuarioPorLogin(login);
        if (usuario == null || !usuario.getSenha().equals(senha)) {
            throw new IllegalArgumentException("Login ou senha inválidos.");
        }
        return usuario;
    }
}
