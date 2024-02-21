package models;

import java.util.ArrayList;
import java.util.List;

public class Diretor extends Artista{
    private static Long nextId = 1L;
    private Long id;
    private List<Filme> producoes;
    
    public Diretor(String nome, String paisOrigem) {
        super(nome, paisOrigem);
        this.id = nextId;
        nextId++;
        this.producoes = new ArrayList<>();
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

    public void setId(Long id) {
        this.id = id;
    }
   
}
