package com.staser.beautifulstring.preparsers;

import com.staser.beautifulstring.parsers.InputTextParser;


public class InputText {

    private InputTextParser inputTextParser;

    /**
     *
     * @param input
     */
    public InputText(String input) {
        this.inputTextParser = new InputTextParser(input);

    }

    /**
     * method calls parser for getting array of strings (draft sentences)
     * @return String[]
     */
    public String[] getSentencesArray() {
        return this.inputTextParser.parseInputToSentences();

    }

}
