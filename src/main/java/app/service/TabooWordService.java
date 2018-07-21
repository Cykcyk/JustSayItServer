package app.service;

import app.controller.TabooWordResource;
import app.dao.TabooWord;
import app.dao.TabooWordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    public List<TabooWordResource> drawTabooWords(Integer size, List<String> categories, Integer difficultLevel){
        List<Long> shuffledIds = shuffleAvailableIds(categories, difficultLevel);
        List<TabooWord> tabooWords = tabooWordDao.getTabooWords(shuffledIds.subList(0 , size));
        List<TabooWordResource> shuffledTabooWords = new ArrayList<>();
        for(TabooWord i: tabooWords){
            shuffledTabooWords.add(new TabooWordResource(i));
        }
        return shuffledTabooWords;
    }

    private List <Long> shuffleAvailableIds(List<String> categories, Integer difficultLevel){
        List <Long> availableIDs = tabooWordDao.getListOfIds(categories, difficultLevel);
        Collections.shuffle(availableIDs);
        return availableIDs;
    }

    public void deleteTabooWord(Long id){
        tabooWordDao.deleteTabooWord(id);
    }
}
