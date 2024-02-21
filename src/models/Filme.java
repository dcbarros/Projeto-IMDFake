package models;

import java.util.Collections;
import java.util.List;

public class Filme {

    private static Long nextId = 1L;
    private Long id;
    private String nome;
    private Integer anoLancamento;
    private Diretor diretor;
    private List<Ator> atores;
    private String estudio;
    private List<String> genero;
    private Integer score;

    public Filme(String nome, 
        Integer anoLancamento, 
        Diretor diretor, 
        List<Ator> atores, 
        String estudio, 
        List<String> genero,
        Integer score) {
            this.nome = nome;
            this.anoLancamento = anoLancamento;
            this.diretor = diretor;
            this.atores = atores;
            this.estudio = estudio;
            this.genero = genero;
            this.score = score;
            this.id = nextId;
            nextId++;
    }    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public Diretor getDiretor() {
        return diretor;
    }
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
    public List<Ator> getAtores() {
        return this.atores;
    }
    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }
    public String getEstudio() {
        return estudio;
    }
    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public List<String> getGenero() {
        return genero;
    }

    public void setGenero(List<String> genero) {
        this.genero = genero;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
}
