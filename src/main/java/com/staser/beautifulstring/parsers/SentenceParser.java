package com.staser.beautifulstring.parsers;


/**
 * class parse sentences to words by " "
 */
public class SentenceParser {


    /**
     * * method excludes empty elements from array of words
     * @param sentence
     * @return String[]
     */
    public String[] parseSentencesToWords(String sentence) {

        String[] _draftWordsArray = this.parseSentencesToDraftWords(sentence);

        // it finds new string array length
        int _length = 0;
        for (String _tempWord : _draftWordsArray) {
            if (!_tempWord.trim().equals("")) {
                _length++;
            }
        }

        String[] _wordsArray = new String[_length];

        int _index = 0;
        for (String _tempWord : _draftWordsArray) {

            String _temp = _tempWord.trim();
            if (!_temp.equals("")) {
                _wordsArray[_index] = _temp;
                _index++;
            }


        }
        return _wordsArray;
    }

    /**
     * internal method split input string to array of words
     * can include empty elements
     * @param sentence
     * @return String[]
     */
    private String[] parseSentencesToDraftWords(String sentence) {

        return sentence.trim().replace(",", ", ").split(" ");

    }


}
