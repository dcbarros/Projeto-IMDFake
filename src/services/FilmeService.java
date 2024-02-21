package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import db.DbModelRepository;
import models.Ator;
import models.Diretor;
import models.Filme;
import models.Exceptions.InvalidResponse;

import repository.FilmesRepository;

public class FilmeService {

    private FilmesRepository filmesRepository;

    public FilmeService() 
    {
        this.filmesRepository = new FilmesRepository(new DbModelRepository());
    }

    public void add(Filme filme){
        if(filme == null ||
            filme.getNome().isBlank() ||
            filme.getNome() == null
        ){
            throw new InvalidResponse("O Filme deve ter um nome e não nulo");
        }
        if(getFilmByNome(filme.getNome()).size() == 0){
            if(filme.getAnoLancamento() > LocalDate.now().getYear() ||
                filme.getAnoLancamento() < 0){
                    throw new InvalidResponse("Ano Inválido");
            }
            if(filme.getScore() < 0 || filme.getScore() > 100){
                throw new InvalidResponse("Score deve está entre 0 a 100");
            }
            filmesRepository.add(filme);
        }else{
            if(yearIsSame(filme)){
                throw new InvalidResponse("Houve um erro ao registrar o filme");
            }
            filmesRepository.add(filme);
        }
    }

    public void update(Long id, List<Ator> atores, Diretor diretor){
        Filme filme = (Filme) filmesRepository.findById(id);
        if(filme == null){
            throw new InvalidResponse("Id não existente");
        }
        if(atores == null && diretor == null){
            throw new InvalidResponse("Ocorreu um problema no update");
        }
        if(atores == null && diretor != null){
            filme.setDiretor(diretor);
        }
        if(atores != null && diretor == null){
            List<Ator> castFilme = filme.getAtores();
            for (Ator ator : atores) {
                if(!actorContainsInList(ator, filme)){
                    castFilme.add(ator);
                }
            }
            filme.setAtores(castFilme);
        }

    }

    public void listAllFilms(){
        List<Filme> filmes = filmesRepository.getAll();
        for (Filme filme : filmes) {
            System.out.printf("%d - %s (%d)\n", filme.getId(), filme.getNome(), filme.getAnoLancamento());
        }
    }

    public List getAllFilms(){
        return Collections.unmodifiableList(filmesRepository.getAll());
    }

    public List getFilmByNome(String input){
        if(input.isBlank() || input == null){throw new InvalidResponse("O input deve possuir pelo menos um caractere");}
        List filme = filmesRepository.findByName(input);
        return filme;
    }

    public Filme getFilmById(Long id){
        if(id == null){
            throw new InvalidResponse("Id inválido");
        }
        Filme filme = (Filme) filmesRepository.findById(id);
        if(filme == null){
            throw new InvalidResponse("Diretor não encontrado!");
        }
        return filme;
    }

    public void addMockerData(){
        List<Ator> atores = new ArrayList<>();
        Filme filme1 = new Filme("Oppenheimer",
         2023, 
         null, 
         atores, 
         "Universal Studios", 
         List.of("Biográfia", "Drama", "Histórico"), 
         84);
        this.add(filme1);
    }

    private Boolean yearIsSame(Filme filme){
        List filmes = getFilmByNome(filme.getNome());

        for (Object object : filmes) {
            Filme filmeListado = (Filme) object;
            if(filmeListado.getNome().equals(filme.getNome())){
                if(filmeListado.getAnoLancamento().equals(filme.getAnoLancamento())){
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean actorContainsInList(Ator ator, Filme filme){
        for (Ator cast : filme.getAtores()) {
            if(ator.getNome().equalsIgnoreCase(cast.getNome())){return true;}
        }
        return false;
    }
}
