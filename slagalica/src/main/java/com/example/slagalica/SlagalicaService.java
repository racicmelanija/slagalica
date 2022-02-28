package com.example.slagalica;

import java.util.List;

public interface SlagalicaService {
    void sortWords();
    List<String> findAllWords(List<String> chars);
    List<String> findWords(List<String> chars, int k);
}
