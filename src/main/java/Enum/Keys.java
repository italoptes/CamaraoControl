package Enum;

import service.UsuarioService;
import io.javalin.config.Key;

public enum Keys {
    USUARIO_SERVICE(new Key<UsuarioService>("usuario-service"))
    ;

    private final Key<?> k;

    <T> Keys(Key<T> key) {
        this.k = key;
    }

    public <T> Key<T> key() {
        @SuppressWarnings("unchecked")
        Key<T> typedKey = (Key<T>) this.k;
        return typedKey;
    }
}
