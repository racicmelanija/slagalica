package com.example.slagalica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SlagalicaServiceImpl implements SlagalicaService{
    private final SlagalicaRepository slagalicaRepository;
    private static final int maxNumOfLetters = 12;

    @Autowired
    public SlagalicaServiceImpl(SlagalicaRepository slagalicaRepository){
        this.slagalicaRepository = slagalicaRepository;
    }

    public List<String> findAllWords(List<String> chars){
        List<String> ret = new ArrayList<>();
        for(int i = maxNumOfLetters; i >= 1; i--){
            ret.addAll(findWords(chars, i));
        }

        return ret;
    }

    public List<String> findWords(List<String> chars, int k){
        List<String> ret = new ArrayList<>();
        Combinations combinations = new Combinations(chars, maxNumOfLetters, k);
        List<List<String>> res = combinations.combine();

        for (List<String> listOfChars: res) {
            List<String> foundWords = slagalicaRepository.findWordsBySortedChars(sortChars(String.join("", listOfChars)));
            for (String word: foundWords) {
                if(word != null){
                    ret.add(word);
                }
            }
        }

        return ret;
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
