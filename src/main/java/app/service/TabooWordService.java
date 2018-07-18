package app.service;

import app.controller.TabooWordResource;
import app.dao.TabooWord;
import app.dao.TabooWordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public void deleteTabooWord(Long id){
        tabooWordDao.deleteTabooWord(id);
    }
}
