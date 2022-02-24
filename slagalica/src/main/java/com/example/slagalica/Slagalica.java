package com.example.slagalica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Slagalica {
    @Id
    private String word;
    @Column
    private String sortedChars;

    public Slagalica() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSortedChars() {
        return sortedChars;
    }

    public void setSortedChars(String sortedChars) {
        this.sortedChars = sortedChars;
    }
}
