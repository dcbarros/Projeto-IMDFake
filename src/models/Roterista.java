package models;

import java.util.ArrayList;
import java.util.List;

public class Roterista extends Artista{

    private List<Filme> producoes;

    public Roterista(String nome, String sobrenome, String paisOrigem) {
        super(nome, sobrenome, paisOrigem);
        this.producoes = new ArrayList<>();
    }

    public List<Filme> getProducoes() {
        return producoes;
    }

    public void setProducoes(List<Filme> producoes) {
        this.producoes = producoes;
    }
    
    
}
