package app.controller;

import app.dao.TabooWord;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TabooWordResource {
    private String mainWord;
    private String firstTabooWord;
    private String secondTabooWord;
    private String thirdTabooWord;
    private String fourthTabooWord;
    private String fifthTabooWord;
    private Integer difficultLevel;

    TabooWordResource(String mainWord, String firstTabooWord, String secondTabooWord, String thirdTabooWord, String fourthTabooWord, String fifthTabooWord, Integer difficultLevel) {
        this.mainWord = mainWord;
        this.firstTabooWord = firstTabooWord;
        this.secondTabooWord = secondTabooWord;
        this.thirdTabooWord = thirdTabooWord;
        this.fourthTabooWord = fourthTabooWord;
        this.fifthTabooWord = fifthTabooWord;
        this.difficultLevel = difficultLevel;
    }

    public TabooWordResource() {

    }

    public TabooWordResource(TabooWord tabooWord){
        this.mainWord = tabooWord.getMainWord();
        this.firstTabooWord = tabooWord.getFirstTabooWord();
        this.secondTabooWord = tabooWord.getSecondTabooWord();
        this.thirdTabooWord = tabooWord.getThirdTabooWord();
        this.fourthTabooWord = tabooWord.getFourthTabooWord();
        this.fifthTabooWord = tabooWord.getFifthTabooWord();
        this.difficultLevel = tabooWord.getDifficultLevel();
    }

    public String getMainWord() {
        return mainWord;
    }

    public void setMainWord(String mainWord) {
        this.mainWord = mainWord;
    }

    public String getFirstTabooWord() {
        return firstTabooWord;
    }

    public void setFirstTabooWord(String firstTabooWord) {
        this.firstTabooWord = firstTabooWord;
    }

    public String getSecondTabooWord() {
        return secondTabooWord;
    }

    public void setSecondTabooWord(String secondTabooWord) {
        this.secondTabooWord = secondTabooWord;
    }

    public String getThirdTabooWord() {
        return thirdTabooWord;
    }

    public void setThirdTabooWord(String thirdTabooWord) {
        this.thirdTabooWord = thirdTabooWord;
    }

    public String getFourthTabooWord() {
        return fourthTabooWord;
    }

    public void setFourthTabooWord(String fourthTabooWord) {
        this.fourthTabooWord = fourthTabooWord;
    }

    public String getFifthTabooWord() {
        return fifthTabooWord;
    }

    public void setFifthTabooWord(String fifthTabooWord) {
        this.fifthTabooWord = fifthTabooWord;
    }

    public Integer getDifficultLevel() {
        return difficultLevel;
    }

    public void setDifficultLevel(Integer difficultLevel) {
        this.difficultLevel = difficultLevel;
    }
}
