package com.staser.beautifulstring.converters;

import android.util.Log;
import com.staser.beautifulstring.models.Sentence;

/**
 * class that prepares output correct string
 */
public class Converter {

    private Sentence[] readyToConvertArray;

    /**
     *
     * @param readyToConvertArray
     */
    public Converter(Sentence[] readyToConvertArray) {
        this.readyToConvertArray = readyToConvertArray;
    }

    /**
     * method operates by array of Sentence objects and prepares output String using StringBuilder
     * @return
     */
    public String getOutputString() {

        String _outputSentence = "";
        StringBuilder _stringBuilder = new StringBuilder();

        for (Sentence _sentence : this.readyToConvertArray) {
            Log.d("LOG", "... ... " + _sentence.toString());

            String[] _words = _sentence.getWords();

            StringBuilder _capitalisationBuilder = new StringBuilder();

            for (int i = 0; i < _words.length; i++) {

                String _tempWord = _words[i].trim();
                    if (i == 0) {
                        _capitalisationBuilder.append(_tempWord.toLowerCase());
                        _capitalisationBuilder.setCharAt(0, Character.toUpperCase(_capitalisationBuilder.charAt(0)));
                    } else {

                        if (_tempWord.startsWith("'") || _tempWord.startsWith("’")) {
                            _capitalisationBuilder.append(_tempWord.toLowerCase());
                        } else {
                            _capitalisationBuilder.append(" ").append(_tempWord.toLowerCase());
                        }
                    }
                    _outputSentence = _capitalisationBuilder.toString();

                }

                _stringBuilder.append(_outputSentence);
                if (_outputSentence.endsWith("...")) {
                    _stringBuilder.append(" ");
                } else {
                    _stringBuilder.append(". ");
                }
        }

        return _stringBuilder.toString();
    }
}
