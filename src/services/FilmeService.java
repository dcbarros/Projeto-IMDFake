package services;

import java.util.Map;

import models.Filme;
import repository.FilmesRepository;

public class FilmeService {
    FilmesRepository _filmesRepository = FilmesRepository.getInstance();

    public Map<Long, Filme> getFilmes(){
        if(_filmesRepository.getTodos().isEmpty()){
            return null;
        }
        return _filmesRepository.getTodos();
    }

    public void addFilme(Filme filme){
        if(filme.equals(null)){
            System.out.println("Deve-se ter um filme para se adicionar");
        }
        _filmesRepository.addFilme(filme);
    }
}
