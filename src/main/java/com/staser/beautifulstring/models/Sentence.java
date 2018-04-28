package com.staser.beautifulstring.models;

import java.util.Arrays;


/**
 * sentence model
 */
public class Sentence {
    
    private int id;
    private String[] words;

    public Sentence(int id, String[] words) {
        this.id = id;
        this.words = words;
    }


    public String[] getWords() {

        return this.words;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "id=" + this.id +
                ", words=" + Arrays.toString(this.words) +
                '}';
    }
}
