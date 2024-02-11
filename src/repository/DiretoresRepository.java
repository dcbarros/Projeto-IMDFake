package repository;

import java.util.HashMap;
import java.util.Map;

import models.Diretor;


public class DiretoresRepository {
    
    private static Long idNext = 1L;
    private Long id;
    private Map<Long, Diretor> dbDiretores;
    private static DiretoresRepository instance;

    private DiretoresRepository(){
        inicializarDados();
    }

    public static synchronized DiretoresRepository getInstance(){
        if (instance == null) {
            instance = new DiretoresRepository();
        }
        return instance;
    }

    private void inicializarDados() {
        this.dbDiretores = new HashMap<>();
        this.id = idNext++;
        dbDiretores.put(id,new Diretor("Frank Darabont", "França"));
        this.id = idNext++;
        dbDiretores.put(id,new Diretor("Robert Zameckis", "Estados Unidos"));
        this.id = idNext++;
        dbDiretores.put(id,new Diretor("David Fincher", "Estados Unidos"));
        this.id = idNext++;
    }

    public Map<Long, Diretor> getTodos() {
        return this.dbDiretores;
    }

    public Diretor getDiretorPorChave(Long key){
        if(containsKey(key)){
            return this.dbDiretores.get(key);
        }
        return null;
    }

    public Map<Long, Diretor> getDiretorPorNome(String nome){
        for (Map.Entry<Long,Diretor> diretor : dbDiretores.entrySet()) {
            if(diretor.getValue().getNome().equalsIgnoreCase(nome)){
                Map<Long,Diretor> diretorEncontrado = new HashMap<>();
                diretorEncontrado.put(diretor.getKey(),diretor.getValue());
                return diretorEncontrado;
            }
        }
        return null;
    }

    //Fazer o método else
    public void addDiretor(Diretor diretor){
        if(!containsDiretor(diretor)){
            this.id = idNext++;
            this.dbDiretores.put(id,diretor);
        }else{

        }
    }


    private boolean containsDiretor(Diretor diretor){
        for (Map.Entry<Long, Diretor> diretoresBanco : this.dbDiretores.entrySet()) {
            if(diretoresBanco.getValue().getNome().equalsIgnoreCase(diretor.getNome())){
                return true;
            }
        }
        return false;
    }

    private boolean containsKey(Long key) {
        return this.dbDiretores.containsKey(key);
    }

}
