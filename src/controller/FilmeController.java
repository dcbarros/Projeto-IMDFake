package controller;

import java.util.Map;

import models.Filme;
import services.FilmeService;

public class FilmeController {
    FilmeService _filmeService = new FilmeService();

    public Map<Long, Filme> getFilmes(){
        return _filmeService.getFilmes();
    }

    public void addFilme(Filme filme){
        _filmeService.addFilme(filme);
    }
}
