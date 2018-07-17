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
        TabooWord tabooWord = new TabooWord(tabooWordResource.getMainWord(), tabooWordResource.getFirstTabooWord(), tabooWordResource.getSecondTabooWord(), tabooWordResource.getThirdTabooWord(),
                                            tabooWordResource.getFourthTabooWord(), tabooWordResource.getFifthTabooWord(), tabooWordResource.getDifficultLevel());
        tabooWordDao.addTabooWord(tabooWord);

    }


    public void updateTabooWord(Long id, TabooWordResource tabooWordResource){
        TabooWord tabooWord = new TabooWord(id, tabooWordResource.getMainWord(), tabooWordResource.getFirstTabooWord(), tabooWordResource.getSecondTabooWord(), tabooWordResource.getThirdTabooWord(),
                tabooWordResource.getFourthTabooWord(), tabooWordResource.getFifthTabooWord(), tabooWordResource.getDifficultLevel());
        TabooWord oldTabooWord = tabooWordDao.getTabooWord(id);
        if(!oldTabooWord.equals(tabooWord)){
            tabooWordDao.update(tabooWord);
        }
    }

    public void deleteTabooWord(Long id){
        tabooWordDao.deleteTabooWord(id);
    }
}
