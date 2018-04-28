package com.staser.beautifulstring.parsers;

import com.staser.beautifulstring.commons.Common;

/**
 * class parses input text to draft of sentences by "."
 */
public class InputTextParser {

    private String inputText;
    private boolean isThreePointsFlag = false;

    /**
     *
     * @param inputText
     */
    public InputTextParser(String inputText) {
        this.inputText = inputText.trim();
    }

    /**
     * method excludes empty elements from array of strings (draft sentences)
     * replace CHANGE' to "..." back
     * @return String[]
     */
    public String[] parseInputToSentences() {

        String[] _draftSentencesArray = this.parseInputToDraftSentences();

        // it finds new string array length
        int _length = 0;
        for (String _tempSentence : _draftSentencesArray) {
            if (!_tempSentence.trim().equals("")) {
                _length++;
            }
        }

        String[] _sentencesArray = new String[_length];
        int _index = 0;
        for (String _tempSentence : _draftSentencesArray) {

            String _temp = _tempSentence.trim();
            if (!_temp.equals("")) {

                if (this.isThreePointsFlag) {

                    if (_tempSentence.contains(Common.THREE_POINTS_CHANGE_BACK)) {
                        _temp = _tempSentence.replace(Common.THREE_POINTS_CHANGE_BACK, Common.THREE_POINTS);
                    }
                }
                _sentencesArray[_index] = _temp;
                _index++;
            }


        }

        return _sentencesArray;
    }

    /**
     * internal method split input string to array of strings (draft sentences) by "."
     * can include empty elements
     * replace "..." to CHANGE'
     * @return String[]
     */

    private String[] parseInputToDraftSentences() {

        String _temp = "";
        if (this.inputText.contains(Common.THREE_POINTS)) {
            this.isThreePointsFlag = true;
            _temp = this.inputText.replace(Common.THREE_POINTS, Common.THREE_POINTS_CHANGE);
            return _temp.split("\\.");
        }
        return this.inputText.split("\\.");
    }

}
