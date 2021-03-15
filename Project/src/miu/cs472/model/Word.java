package miu.cs472.model;

public class Word {
	private String word;
    private String wordtype;
    private String definition;

    public Word(String word, String wordtype, String definition) {
        this.word = word;
        this.wordtype = wordtype;
        this.definition = definition;
    }

    public Word() {
    }

    public String getWord() {
        return word;
    }

    public String getWordtype() {
        return wordtype;
    }

    public String getDefinition() {
        return definition;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setWordtype(String wordtype) {
        this.wordtype = wordtype;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
