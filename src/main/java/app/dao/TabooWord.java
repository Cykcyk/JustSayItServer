package app.dao;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "taboo_words")
public class TabooWord {

    @Id @GeneratedValue
    @Column(name = "taboo_word_id")
    private Long id;

    @Column(name = "main_word")
    private String mainWord;

    @Column(name = "first_taboo_word")
    private String firstTabooWord;

    @Column(name = "second_taboo_word")
    private String secondTabooWord;

    @Column(name = "third_taboo_word")
    private String thirdTabooWord;

    @Column(name = "fourth_taboo_word")
    private String fourthTabooWord;

    @Column(name = "fifth_taboo_word")
    private String fifthTabooWord;

    @Column(name = "difficult_level")
    private Integer difficultLevel;

    public TabooWord(){}

    public TabooWord(String mainWord, String firstTabooWord, String secondTabooWord, String thirdTabooWord, String fourthTabooWord, String fifthTabooWord, Integer difficultLevel){
        this.mainWord = mainWord;
        this.firstTabooWord = firstTabooWord;
        this.secondTabooWord = secondTabooWord;
        this.thirdTabooWord = thirdTabooWord;
        this.fourthTabooWord = fourthTabooWord;
        this.fifthTabooWord = fifthTabooWord;
        this.difficultLevel = difficultLevel;
    }

    public TabooWord(Long id, String mainWord, String firstTabooWord, String secondTabooWord, String thirdTabooWord, String fourthTabooWord, String fifthTabooWord, Integer difficultLevel){
        this.id = id;
        this.mainWord = mainWord;
        this.firstTabooWord = firstTabooWord;
        this.secondTabooWord = secondTabooWord;
        this.thirdTabooWord = thirdTabooWord;
        this.fourthTabooWord = fourthTabooWord;
        this.fifthTabooWord = fifthTabooWord;
        this.difficultLevel = difficultLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabooWord tabooWord = (TabooWord) o;
        return Objects.equals(id, tabooWord.id) &&
                Objects.equals(mainWord, tabooWord.mainWord) &&
                Objects.equals(firstTabooWord, tabooWord.firstTabooWord) &&
                Objects.equals(secondTabooWord, tabooWord.secondTabooWord) &&
                Objects.equals(thirdTabooWord, tabooWord.thirdTabooWord) &&
                Objects.equals(fourthTabooWord, tabooWord.fourthTabooWord) &&
                Objects.equals(fifthTabooWord, tabooWord.fifthTabooWord) &&
                Objects.equals(difficultLevel, tabooWord.difficultLevel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mainWord, firstTabooWord, secondTabooWord, thirdTabooWord, fourthTabooWord, fifthTabooWord, difficultLevel);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
