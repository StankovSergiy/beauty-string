package com.staser.beautifulstring.preparsers;

import com.staser.beautifulstring.models.Sentence;
import com.staser.beautifulstring.parsers.SentenceParser;


public class ReadyToConvert {

    private String[] sentencesArray;
    private SentenceParser sentenceParser;

    /**
     *
      * @param sentencesArray
     */
    public ReadyToConvert(String[] sentencesArray) {

        this.sentencesArray = sentencesArray;
        this.sentenceParser = new SentenceParser();

    }

    /**
     * method calls parser for getting array of sentences
     * it parses ewery draft sentence to array of words and create new Sentence object to put it into array of Sentences
     * @return Sentence[]
     */
    public Sentence[] getReadyToConvert() {

        Sentence[] _readyToConvert = new Sentence[this.sentencesArray.length];

        for (int i = 0; i < this.sentencesArray.length; i++) {

            if (this.sentencesArray[i]!=null) {
                String _sentence = this.sentencesArray[i].trim();

                String[] _wordsArray = this.sentenceParser.parseSentencesToWords(_sentence);

                Sentence _sentenceObject = new Sentence(i, _wordsArray);

                _readyToConvert[i] = _sentenceObject;
            }
        }
        return _readyToConvert;
    }
}