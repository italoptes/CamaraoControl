package util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Adaptador personalizado para serializar e desserializar objetos LocalDate com Gson.
 *
 * Essa classe estende TypeAdapter do Gson para permitir a conversão de objetos LocalDate
 * para String no formato ISO-8601 (ex: "2025-07-19") ao serializar para JSON, e reconvertê-los
 * de volta para LocalDate ao desserializar do JSON.
 *
 * Métodos:
 * - write(JsonWriter out, LocalDate value): Converte o LocalDate para string e escreve no JSON.
 * - read(JsonReader in): Lê a string do JSON e a converte de volta para um objeto LocalDate.
 *
 * Isso é útil porque o Gson, por padrão, não sabe como lidar com tipos do pacote java.time.
 */

public class LocalDateAdapter extends TypeAdapter<LocalDate> {
    @Override
    public void write(JsonWriter out, LocalDate value) throws IOException {
        out.value(value.toString());
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException {
        return LocalDate.parse(in.nextString());
    }
}
