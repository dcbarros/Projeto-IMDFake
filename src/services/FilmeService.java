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

    public Map<Long, Filme> getFilmePorNome(String nome){
        Map<Long,Filme> filmeEncontrado = _filmesRepository.getFilmePorNome(nome);
        if(filmeEncontrado.isEmpty()){
            return null;
        }
        return filmeEncontrado;
    }

    public Map<Long, Filme> getFilmePorId(Long id){
        return _filmesRepository.getFilmePorId(id);
    }

    public void addFilme(Filme filme){
        if(filme.equals(null)){
            System.out.println("Deve-se ter um filme para se adicionar");
        }
        if(filme.getScore() < 0 && filme.getScore() > 100){
            System.out.println("Score inserido é inválido");
        }else{
            System.out.println("Filme adicionado com sucesso!");
            _filmesRepository.addFilme(filme);
        }
    }

    public void addFilmeAoAtor(Long id, Filme filme){
        _filmesRepository.atribuirFilmeAAtor(id, filme);
    }

    public void addFilmeAoDiretor(Long id, Filme filme){
        _filmesRepository.atribuirFilmeADiretor(id, filme);
    }
}
