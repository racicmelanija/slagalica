package com.example.slagalica;

import java.util.*;

public class Combinations {
    private final List<String> chars;
    private final List<List<String>> resultSet = new LinkedList<>();
    private final int n;
    private final int k;

    public Combinations(List<String> array, int n, int k){
        this.chars = array;
        this.n = n;
        this.k = k;
    }

    public List<List<String>> combine(){
        backtrack(0, new LinkedList<>());
        return resultSet;
    }

    private void backtrack(int first, LinkedList<String> curr){
        if(curr.size() == k){
            resultSet.add(new LinkedList<>(curr));
        }

        for(int i = first; i < n; ++i){
            curr.add(chars.get(i));
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }
}
