package models;

import java.util.ArrayList;
import java.util.List;

public class Diretor extends Artista{

    private List<Filme> producoes;
    
    public Diretor(String nome, String paisOrigem) {
        super(nome, paisOrigem);
        this.producoes = new ArrayList<>();
    }

    public List<Filme> getProducoes() {
        return producoes;
    }

    public void setProducoes(List<Filme> producoes) {
        this.producoes = producoes;
    }
    
    
}
