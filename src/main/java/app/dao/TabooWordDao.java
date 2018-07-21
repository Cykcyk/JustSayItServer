package app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class TabooWordDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void addTabooWord(TabooWord tabooWord){
        entityManager.persist(tabooWord);
    }

    public TabooWord getTabooWord (Long tabooWordId){
        return entityManager.find(TabooWord.class, tabooWordId);
    }

    public List<TabooWord> getTabooWords(List<Long> listOfIds){
       return entityManager.createQuery("from TabooWord tb where id in :listOfIds").setParameter("listOfIds", listOfIds).getResultList();
    }

    public void update(TabooWord tabooWord){
        entityManager.merge(tabooWord);
    }

    public void deleteTabooWord(Long tabooWordId){
        entityManager.remove(getTabooWord(tabooWordId));
    }

    public List <Long> getListOfIds(List<String> categories, Integer difficultLevel){
        List<Long> availableIDs;
        if (categories != null) {
            availableIDs = entityManager.createQuery("select id from TabooWord where category in :categories and difficultLevel >= :difficultLevel")
                    .setParameter("categories", categories).setParameter("difficultLevel", difficultLevel).getResultList();
            }
            else {
            availableIDs = entityManager.createQuery("select id from TabooWord where difficultLevel >= :difficultLevel")
                                        .setParameter("difficultLevel", difficultLevel).getResultList();
        }
        return availableIDs;
    }
}

