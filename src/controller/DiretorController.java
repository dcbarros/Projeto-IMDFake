package controller;

import java.util.List;

import models.Diretor;
import models.Filme;
import services.DiretorService;

public class DiretorController {
    
    private DiretorService diretorService = new DiretorService();

    public void add(Diretor diretor){
        this.diretorService.addDirector(diretor);
    }

    public void update(Long id, Filme filme){
        this.diretorService.update(id, filme);
    }

    public void listAllDirectos(){
        this.diretorService.listAllDirectos();
    }

    public List getAll(){
        return this.diretorService.getAllDirectors();
    }

    public List getDirectorByName(String input){
        return diretorService.getDirectorByNome(input);
    }

    public Diretor getDiretorById(Long id){
        return this.diretorService.getDirectorById(id);
    }

    public void addMockData(){
        this.diretorService.addMockerData();
    }
}
