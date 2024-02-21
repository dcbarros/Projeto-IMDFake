package controller;

import java.util.List;

import models.Ator;
import models.Filme;
import services.AtorService;

public class AtorController {
    
    private AtorService atorService = new AtorService();

    public void add(Ator ator){
        this.atorService.addActor(ator);
    }
    public void update (Long id, Filme filme){
        this.atorService.update(id, filme);
    }

    public List getAll(){
        return this.atorService.getAllActors();
    }

    public List getActorByName(String input){
        return atorService.getActorByNome(input);
    }

    public Ator getActorById(Long id){
        return atorService.getActorById(id);
    }
    
    public void listAllActors(){
        this.atorService.listAllActors();
    }

    public void addMockData(){
        this.atorService.addMockerData();
    }
}
