package models;

public abstract class Artista {

    private String nome;
    private String paisOrigem;

    public Artista(String nome, String paisOrigem) {
        this.nome = nome;
        this.paisOrigem = paisOrigem;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPaisOrigem() {
        return paisOrigem;
    }
    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }
  
}
