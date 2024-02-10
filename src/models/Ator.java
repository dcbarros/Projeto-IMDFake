package models;

import java.util.ArrayList;
import java.util.List;

public class Ator extends Artista{

    // Id irá começar por 0 para coicidir com a posição do ator na lista;
    
    private static Long nextId = 0L;
    private Long id;
    private List<Filme> producoes;

    public Ator(String nome, String paisOrigem) {
        super(nome, paisOrigem);
        this.producoes = new ArrayList<>();
        this.id = nextId++;
    }

    public List<Filme> getProducoes() {
        return producoes;
    }

    public void setProducoes(List<Filme> producoes) {
        this.producoes = producoes;
    }

    public Long getId() {
        return id;
    }

}
