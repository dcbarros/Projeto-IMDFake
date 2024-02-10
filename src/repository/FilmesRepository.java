package repository;

import java.util.ArrayList;
import java.util.List;

import models.Filme;

public class FilmesRepository {
    AtoresRepository _atoresRepository = new AtoresRepository();
    DiretoresRepository _diretoresRepository = new DiretoresRepository();

    List<Filme> dbFilmes;

    public FilmesRepository() {
        this.dbFilmes = new ArrayList<>();
        inicializarDados();
    }

    private void inicializarDados() {
        // adicionar(new Filme("Os Condenados de Shawshank", 
        // 1994, 
        // _diretoresRepository.getPorId(0L),
        //  List.of(_atoresRepository.getPorId(0L),_atoresRepository.getPorId(1L),_atoresRepository.getPorId(2L)), 
        //  "Warner Bros. Pictures", 
        //  List.of("Drama"), 
        //  93));
         
        //  adicionar(new Filme("Forrest Gump", 
        //  1994, 
        //  _diretoresRepository.getPorId(1L),
        //   List.of(_atoresRepository.getPorId(3L),_atoresRepository.getPorId(4L),_atoresRepository.getPorId(5L)), 
        //   "Paramount", 
        //   List.of("Drama", "Romance"), 
        //   88));
        //   adicionar(new Filme("O Clube da Luta", 
        //   1999, 
        //   _diretoresRepository.getPorId(2L),
        //    List.of(_atoresRepository.getPorId(6L),_atoresRepository.getPorId(7L),_atoresRepository.getPorId(8L)), 
        //    "Fox Studios", 
        //    List.of("Drama"), 
        //    88));
        Filme f1 = new Filme("O Clube da Luta", 
          1999, 
          _diretoresRepository.getPorId(2L),
           List.of(_atoresRepository.getPorId(6L),_atoresRepository.getPorId(7L),_atoresRepository.getPorId(8L)), 
           "Fox Studios", 
           List.of("Drama"), 
           88);
        atribuirFilmeAtor(f1, 0L);
        
    }

    public void adicionar(Filme filme) {
        dbFilmes.add(filme);
    }

    public void atribuirFilmeAtor(Filme filme, Long idAtor){
        List<Filme> producoes = _atoresRepository.getPorId(idAtor).getProducoes();
        producoes.add(filme);
        _atoresRepository.getPorId(idAtor).setProducoes(producoes);
    }
    
    public List<Filme> getTodos(){
        return this.dbFilmes;
    }
    
}
