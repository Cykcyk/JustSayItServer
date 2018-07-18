package app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public void update(TabooWord tabooWord){
        entityManager.merge(tabooWord);
    }

    public void deleteTabooWord(Long tabooWordId){
        entityManager.remove(getTabooWord(tabooWordId));
    }

    public List <Long> getListOfIdsOfTabooWords(){
        List <Long> availableIDs = entityManager.createQuery("select  id from TabooWord").getResultList();
        return availableIDs;
    }
}
