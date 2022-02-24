package com.example.slagalica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SlagalicaServiceImpl implements SlagalicaService{
    private final SlagalicaRepository slagalicaRepository;

    @Autowired
    public SlagalicaServiceImpl(SlagalicaRepository slagalicaRepository){
        this.slagalicaRepository = slagalicaRepository;
    }

    public void sortWords(){
        List<Slagalica> allWords = slagalicaRepository.findAll();

        for (Slagalica s : allWords) {
            s.setSortedChars(sortChars(s.getWord()));
        }
        slagalicaRepository.saveAll(allWords);
    }

    private static String sortChars(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
