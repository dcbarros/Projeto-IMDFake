package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Ator;
import models.Diretor;
import models.Filme;

public class FilmesRepository {
    
    DiretoresRepository _diretoresRepository = DiretoresRepository.getInstance();
    AtoresRepository _atoresRepository = AtoresRepository.getInstance();

    private static Long idNext = 1L;
    private Long id;
    private Map<Long, Filme> dbFilmes;
    private static FilmesRepository instance;

    private FilmesRepository(){
        inicializarDados();
    }

    public static synchronized FilmesRepository getInstance(){
        if (instance == null) {
            instance = new FilmesRepository();
        }
        return instance;
    }

    private void inicializarDados() {
        this.dbFilmes = new HashMap<>();

        Diretor diretor1 = _diretoresRepository.getDiretorPorChave(1L);
        Diretor diretor2 = _diretoresRepository.getDiretorPorChave(2L);
        Diretor diretor3 = _diretoresRepository.getDiretorPorChave(3L);

        Ator ator1 = _atoresRepository.getAtorPorChave(1L);
        Ator ator2 = _atoresRepository.getAtorPorChave(2L);
        Ator ator3 = _atoresRepository.getAtorPorChave(3L);
        Ator ator4 = _atoresRepository.getAtorPorChave(4L);
        Ator ator5 = _atoresRepository.getAtorPorChave(5L);
        Ator ator6 = _atoresRepository.getAtorPorChave(6L);
        Ator ator7 = _atoresRepository.getAtorPorChave(7L);
        Ator ator8 = _atoresRepository.getAtorPorChave(8L);
        Ator ator9 = _atoresRepository.getAtorPorChave(9L);

        this.id = idNext++;
        List<Ator> castAtores1 = new ArrayList<>();
        castAtores1.add(ator1);
        castAtores1.add(ator2);
        castAtores1.add(ator3);
        List<Ator> castAtores2 = new ArrayList<>();
        castAtores2.add(ator4);
        castAtores2.add(ator5);
        castAtores2.add(ator6);
        List<Ator> castAtores3 = new ArrayList<>();
        castAtores3.add(ator7);
        castAtores3.add(ator8);
        castAtores3.add(ator9);

        Filme filme1 = new Filme("Os Condenados de Shawshank"
                                    ,1994
                                    ,diretor1, 
                                    castAtores1, 
                                    "Warner Bros. Pictures", 
                                    new ArrayList<>(List.of("Drama")), 
                                    93);
        dbFilmes.put(id,filme1);
        atribuirFilmeADiretor(1L, filme1);
        atribuirFilmeAAtor(1L, filme1);
        atribuirFilmeAAtor(2L, filme1);
        atribuirFilmeAAtor(3L, filme1);

        this.id = idNext++;
        Filme filme2 = new Filme("Forrest Gump"
                                    ,1994
                                    ,diretor2, 
                                    castAtores2, 
                                    "Paramout", 
                                    new ArrayList<>(List.of("Drama, Romance")), 
                                    88);

        dbFilmes.put(id,filme2);
        atribuirFilmeADiretor(2L, filme2);
        atribuirFilmeAAtor(4L, filme2);
        atribuirFilmeAAtor(5L, filme2);
        atribuirFilmeAAtor(6L, filme2);

        this.id = idNext++;
        Filme filme3 = new Filme("Clube da Luta"
                                    ,1999
                                    ,diretor3, 
                                    castAtores3, 
                                    "Fox Studios", 
                                    new ArrayList<>(List.of("Drama")), 
                                    87);

        dbFilmes.put(id,filme3);
        atribuirFilmeADiretor(3L, filme3);
        atribuirFilmeAAtor(7L, filme3);
        atribuirFilmeAAtor(8L, filme3);
        atribuirFilmeAAtor(9L, filme3);

    }

    public void atribuirFilmeADiretor(Long id, Filme filme){
        Diretor diretor = _diretoresRepository.getDiretorPorChave(id);
        if(diretor.equals(null)){
            System.out.println("O Id: "+ id +" não existe");
        }else{
            List<Filme> producoes = diretor.getProducoes();
            producoes.add(filme);
            diretor.setProducoes(producoes);
        }
    }

    public void atribuirFilmeAAtor(Long id, Filme filme){
        Ator ator = _atoresRepository.getAtorPorChave(id);
        if(ator.equals(null)){
            System.out.println("O Id: "+ id +" não existe");
        }else{
            if (!filme.getAtores().contains(ator) || filme.getAtores().isEmpty()) {

                List<Filme> producoes = new ArrayList<>(ator.getProducoes());
                producoes.add(filme);
                ator.setProducoes(producoes);
    

                List<Ator> estrelasProducao = new ArrayList<>(filme.getAtores());
                estrelasProducao.add(ator);
                filme.setAtores(estrelasProducao);
            }
        }
    }

    public Map<Long,Filme> getFilmePorNome(String nome){
        Map<Long,Filme> listaFilmes = new HashMap<>();
        for (Map.Entry<Long,Filme> filme : dbFilmes.entrySet()) {
            if(filme.getValue().getNome().toLowerCase().contains(nome.toLowerCase())){
                listaFilmes.put(filme.getKey(), filme.getValue());
            }
        }
        return listaFilmes;
    }

    public Map<Long,Filme> getFilmePorId(Long id){
        if(containsKey(id)){
            Map<Long,Filme> filmeEncontrado = new HashMap<>();
            filmeEncontrado.put(id, this.dbFilmes.get(id));
            return filmeEncontrado;
        }
        return null;
    }

    public Map<Long, Filme> getTodos(){
        return this.dbFilmes;
    }

    public void addFilme(Filme filme){
        if(!containsFilme(filme)){
            this.id = idNext++;
            this.dbFilmes.put(id, filme);
        }
    }

    private boolean containsFilme(Filme filme){
        for (Map.Entry<Long, Filme> filmeBanco : this.dbFilmes.entrySet()) {
            if(filmeBanco.getValue().getNome().equalsIgnoreCase(filme.getNome())){
                return true;
            }
        }
        return false;
    }

    private boolean containsKey(Long key) {
        return this.dbFilmes.containsKey(key);
    }


}
