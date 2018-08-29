package app.dao;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "taboo_words")
public class TabooWord {


     @Id
     @GeneratedValue
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

     @Column(name = "category")
     private String category;

     @Column(name = "difficult_level")
     private Integer difficultLevel;

     private TabooWord(){}

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
                Objects.equals(category, tabooWord.category) &&
                Objects.equals(difficultLevel, tabooWord.difficultLevel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mainWord, firstTabooWord, secondTabooWord, thirdTabooWord, fourthTabooWord, fifthTabooWord, category, difficultLevel);
    }

    public Long getId() {
        return id;
    }

    public String getMainWord() {
        return mainWord;
    }

    public String getFirstTabooWord() {
        return firstTabooWord;
    }

    public String getSecondTabooWord() {
        return secondTabooWord;
    }

    public String getThirdTabooWord() {
        return thirdTabooWord;
    }

    public String getFourthTabooWord() {
        return fourthTabooWord;
    }

    public String getFifthTabooWord() {
        return fifthTabooWord;
    }

    public String getCategory(){
        return category;
    }

    public Integer getDifficultLevel() {
        return difficultLevel;
    }

    public static class TabooWordBuilder {

        private Long id;
        private String mainWord;
        private String firstTabooWord;
        private String secondTabooWord;
        private String thirdTabooWord;
        private String fourthTabooWord;
        private String fifthTabooWord;
        private String category;
        private Integer difficultLevel;

        public TabooWordBuilder(){

        }

        public TabooWordBuilder withMainWord(String mainWord){
            this.mainWord = mainWord;

            return this;
        }

        public TabooWordBuilder withFirstTabooWord(String firstTabooWord){
            this.firstTabooWord = firstTabooWord;

            return this;
        }

        public TabooWordBuilder withSecondTabooWord(String secondTabooWord){
            this.secondTabooWord = secondTabooWord;

            return this;
        }

        public TabooWordBuilder withThirdTabooWord(String thirdTabooWord){
            this.thirdTabooWord = thirdTabooWord;

            return this;
        }

        public TabooWordBuilder withFourthTabooWord(String fourthTabooWord){
            this.fourthTabooWord = fourthTabooWord;

            return this;
        }

        public TabooWordBuilder withFifthTabooWord(String fifthTabooWord){
            this.fifthTabooWord = fifthTabooWord;

            return this;
        }

        public TabooWordBuilder withCategory(String category){
            this.category = category;

            return  this;
        }

        public TabooWordBuilder withDifficultLevel(Integer difficultLevel){
            this.difficultLevel = difficultLevel;

            return this;
        }

        public TabooWord build(){
            TabooWord tabooWord = new TabooWord();
            tabooWord.id = this.id;
            tabooWord.mainWord = this.mainWord;
            tabooWord.firstTabooWord = this.firstTabooWord;
            tabooWord.secondTabooWord = this.secondTabooWord;
            tabooWord.thirdTabooWord = this.thirdTabooWord;
            tabooWord.fourthTabooWord = this.fourthTabooWord;
            tabooWord.fifthTabooWord = this.fifthTabooWord;
            tabooWord.category = this.category;
            tabooWord.difficultLevel = this.difficultLevel;

            return tabooWord;
        }

    }

}
