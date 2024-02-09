package models;

public abstract class Artista {

    private String nome;
    private String sobrenome;
    private String paisOrigem;

    public Artista(String nome, String sobrenome, String paisOrigem) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.paisOrigem = paisOrigem;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getPaisOrigem() {
        return paisOrigem;
    }
    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }
  
}
