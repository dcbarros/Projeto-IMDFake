package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Diretor;


public class DiretoresRepository {
    
    private List<Diretor> dbDiretores;

    public DiretoresRepository() {
        this.dbDiretores = new ArrayList<>();
        inicializarDados();
    }

    private void inicializarDados() {
        adicionar(new Diretor("Frank Darabont", "França"));
        adicionar(new Diretor("Robert Zemeckis", "Estados Unidos"));
        adicionar(new Diretor("David Fincher", "Estados Unidos"));

    }

    public void adicionar(Diretor diretor) {
        dbDiretores.add(diretor);
    }

    public List<Diretor> getTodos(){
        return Collections.unmodifiableList(this.dbDiretores);
    }

    public Diretor getPorId(Long id){
        return this.dbDiretores.get(id.intValue());
    }

    public List<Diretor> procurarPorPartesNome(String input){
        List<Diretor> diretoresEncontrados = new ArrayList<>();
        for (Diretor diretor : dbDiretores) {
            if(diretor.getNome().toLowerCase().contains(input.toLowerCase())){
                diretoresEncontrados.add(diretor);
            }
        }
        return diretoresEncontrados;
    }

    public Diretor procurarPorNome(String nome){
        for (Diretor diretor : dbDiretores) {
            if(diretor.getNome().equalsIgnoreCase(nome)){
                return diretor;
            }
        }
        return null;
    }

}
