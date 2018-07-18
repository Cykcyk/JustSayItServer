package app.service;

import app.controller.TabooWordResource;
import app.dao.TabooWord;
import app.dao.TabooWordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

@Component
public class TabooWordService {

    @Autowired
    TabooWordDao tabooWordDao;

    public TabooWord getTabooWord(Long id){
        return tabooWordDao.getTabooWord(id);
    }

    public void  setTabooWord(TabooWordResource tabooWordResource){
        TabooWord tabooWord = new TabooWord.TabooWordBuilder()
                .withMainWord(tabooWordResource.getMainWord())
                .withFirstTabooWord(tabooWordResource.getFirstTabooWord())
                .withSecondTabooWord(tabooWordResource.getSecondTabooWord())
                .withThirdTabooWord(tabooWordResource.getThirdTabooWord())
                .withFourthTabooWord(tabooWordResource.getFourthTabooWord())
                .withFifthTabooWord(tabooWordResource.getFifthTabooWord())
                .withDifficultLevel(tabooWordResource.getDifficultLevel())
                .build();

        tabooWordDao.addTabooWord(tabooWord);

    }


    public void updateTabooWord(Long id, TabooWordResource tabooWordResource){
        TabooWord tabooWord = new TabooWord.TabooWordBuilder()
                .withMainWord(tabooWordResource.getMainWord())
                .withFirstTabooWord(tabooWordResource.getFirstTabooWord())
                .withSecondTabooWord(tabooWordResource.getSecondTabooWord())
                .withThirdTabooWord(tabooWordResource.getThirdTabooWord())
                .withFourthTabooWord(tabooWordResource.getFourthTabooWord())
                .withFifthTabooWord(tabooWordResource.getFifthTabooWord())
                .withDifficultLevel(tabooWordResource.getDifficultLevel())
                .build();

        TabooWord oldTabooWord = tabooWordDao.getTabooWord(id);
        if(!oldTabooWord.equals(tabooWord)){
            tabooWordDao.update(tabooWord);
        }
    }

    public Vector<TabooWordResource> drawTabooWords(Integer size){
        List <Long> listOfAvailableIds = shuffleAvailableIds();
        TabooWord tempTabooWord;
        Vector<TabooWordResource> shuffledTabooWords = new Vector<>();
        for (int i = 0; i < size; i++){
            tempTabooWord = getTabooWord(listOfAvailableIds.get(i));
            shuffledTabooWords.add(new TabooWordResource(tempTabooWord));
        }
        return shuffledTabooWords;
    }

    private List <Long> shuffleAvailableIds(){
        List <Long> availableIDs = tabooWordDao.getListOfIdsOfTabooWords();
        Collections.shuffle(availableIDs);
        return availableIDs;
    }

    public void deleteTabooWord(Long id){
        tabooWordDao.deleteTabooWord(id);
    }
}
