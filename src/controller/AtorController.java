package controller;

import java.util.Map;

import models.Ator;
import services.AtorService;

public class AtorController {
    AtorService _atoresService = new AtorService();

    public Map<Long,Ator> getAtores(){
        return _atoresService.getAtores();
    }

    public void addAtor(Ator ator){
        _atoresService.addAtor(ator);
    }
}
