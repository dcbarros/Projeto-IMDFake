package models;

import java.util.Collections;
import java.util.List;

public class Filme {

    private static Long nextId = 0L;
    private Long id;

    private String nome;
    private Integer anoLancamento;
    private Diretor diretor;
    private List<Ator> atores;
    private String estudio;

    public Filme(String nome, 
                    Integer anoLancamento, 
                    Diretor diretor, 
                    List<Ator> atores, 
                String estudio) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
        this.atores = atores;
        this.estudio = estudio;
        this.id = nextId++;
    }
    // TODO: Fazer a implementaçao de melhorias do código
    
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
        return Collections.unmodifiableList(this.atores);
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

    public Long getId() {
        return id;
    }
    
   
}
