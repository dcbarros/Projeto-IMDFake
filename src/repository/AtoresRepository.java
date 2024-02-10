package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Ator;

public class AtoresRepository {

    private List<Ator> dbAtores;

    public AtoresRepository() {
        this.dbAtores = new ArrayList<>();
        inicializarDados();
    }

    private void inicializarDados() {
        // Adicione os atores iniciais à lista
        adicionar(new Ator("Tim", "Robbins", "Estados Unidos"));
        adicionar(new Ator("Morgan", "Freeman", "Estados Unidos"));
        adicionar(new Ator("Bob", "Gunton", "Estados Unidos"));
        adicionar(new Ator("Tim", "Hanks", "Estados Unidos"));
        adicionar(new Ator("Robin", "Wrigth", "Estados Unidos"));
        adicionar(new Ator("Gary", "Sinise", "Estados Unidos"));
        adicionar(new Ator("Brad", "Pitt", "Estados Unidos"));
        adicionar(new Ator("Edward", "Norton", "Estados Unidos"));
        adicionar(new Ator("Meat", "Loaf", "Estados Unidos"));
    }

    public void adicionar(Ator ator) {
        dbAtores.add(ator);
    }

    public List<Ator> getTodos(){
        return Collections.unmodifiableList(this.dbAtores);
    }

    public List<Ator> procurarPorNome(String nome){
        List<Ator> atoresEncontrados = new ArrayList<>();
        for (Ator ator : dbAtores) {
            if(ator.getNome().toLowerCase().contains(nome.toLowerCase())){
                atoresEncontrados.add(ator);
            }
        }
        return atoresEncontrados;
    }
}
