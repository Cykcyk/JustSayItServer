package app.controller;


import app.dao.TabooWord;
import app.service.TabooWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tabooWords")
public class TabooWordController {

    @Autowired
    private TabooWordService tabooWordService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TabooWordResource getTabooWord(@PathVariable Long id){
        TabooWord tabooWord = tabooWordService.getTabooWord(id);
        return new TabooWordResource(tabooWord.getMainWord(), tabooWord.getFirstTabooWord(),
                tabooWord.getSecondTabooWord(), tabooWord.getThirdTabooWord(),
                tabooWord.getFourthTabooWord(), tabooWord.getFifthTabooWord(), tabooWord.getCategory(), tabooWord.getDifficultLevel());
    }

    @RequestMapping(value = "/{id}", method =  RequestMethod.DELETE)    
    public void deleteTabooWord(@PathVariable Long id){
        tabooWordService.deleteTabooWord(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addTabooWord(@RequestBody TabooWordResource tabooWordResource){
        tabooWordService.addTabooWord(tabooWordResource);
    }

    @RequestMapping(value = "/{id}", method =  RequestMethod.PUT)
    public void updateTabooWord(@PathVariable Long id, @RequestBody TabooWordResource tabooWordResource){
        tabooWordService.updateTabooWord(id, tabooWordResource);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TabooWordResource> drawTabooWords (@RequestParam ("size") Integer size,
                                                   @RequestParam (value = "category", required = false) List <String> category,
                                                   @RequestParam (value = "difficult", required = false, defaultValue = "0") Integer difficultLevel){
        return tabooWordService.drawTabooWords(size, category, difficultLevel);
    }
}
