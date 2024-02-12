package controller;

import java.util.Map;

import models.Filme;
import services.FilmeService;

public class FilmeController {
    FilmeService _filmeService = new FilmeService();

    public Map<Long, Filme> getFilmes(){
        return _filmeService.getFilmes();
    }

    
    public Map<Long,Filme> getFilmePorNome(String nome){
        return _filmeService.getFilmePorNome(nome);
    }
    
    public Map<Long,Filme> getFilmePorId(Long id){
        return _filmeService.getFilmePorId(id);
    }

    public void addFilme(Filme filme){
        _filmeService.addFilme(filme);
    }

    public void addFilmeAoAtor(Long id, Filme filme){
        _filmeService.addFilmeAoAtor(id, filme);
    }
}
