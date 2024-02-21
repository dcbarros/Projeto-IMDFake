package controller;

import java.util.List;

import models.Ator;
import models.Diretor;
import models.Filme;
import services.FilmeService;

public class FilmeController {

    private FilmeService filmeService = new FilmeService();

    public void add(Filme filme){
        filmeService.add(filme);
    }

    public void update(Long id, List<Ator> atores, Diretor diretor){
        filmeService.update(id,atores, diretor);
    }

    public void listAllFilms(){
        this.filmeService.listAllFilms();
    }
    
    public List getAll(){
        return this.filmeService.getAllFilms();
    }

    public List getFilmByName(String input){
        return this.filmeService.getFilmByNome(input);
    }
    
    public Filme getFilmById(Long id){
        return this.filmeService.getFilmById(id);
    }

    public List getRanking(){
        return filmeService.getFilmsRanking();
    }

    public void addMockData(){
        this.filmeService.addMockerData();
    }
}
