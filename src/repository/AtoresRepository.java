package repository;

import java.util.HashMap;
import java.util.Map;

import models.Ator;

public class AtoresRepository {

    private static Long idNext = 1L;
    private Long id;
    private Map<Long, Ator> dbAtores;
    private static AtoresRepository instance;

    private AtoresRepository(){
        inicializarDados();
    }

    public static synchronized AtoresRepository getInstance(){
        if (instance == null) {
            instance = new AtoresRepository();
        }
        return instance;
    }

    private void inicializarDados() {
        this.dbAtores = new HashMap<>();
        this.id = idNext++;
        dbAtores.put(id,new Ator("Tim Robbins", "Estados Unidos"));
        this.id = idNext++;
        dbAtores.put(id,new Ator("Morgan Freeman", "Estados Unidos"));
        this.id = idNext++;
        dbAtores.put(id,new Ator("Bob Gunton", "Estados Unidos"));
        this.id = idNext++;
        dbAtores.put(id,new Ator("Tom Hanks", "Estados Unidos"));
        this.id = idNext++;
        dbAtores.put(id,new Ator("Robin Wrigth", "Estados Unidos"));
        this.id = idNext++;
        dbAtores.put(id,new Ator("Gary Sinise", "Estados Unidos"));
        this.id = idNext++;
        dbAtores.put(id,new Ator("Brad Pitt", "Estados Unidos"));
        this.id = idNext++;
        dbAtores.put(id,new Ator("Edward Norton", "Estados Unidos"));
        this.id = idNext++;
        dbAtores.put(id,new Ator("Meat Loaf", "Estados Unidos"));
    }

    public Map<Long, Ator> getTodos() {
        return dbAtores;
    }

    public void addAtor(Ator ator){
        if(!containsAtor(ator)){
            this.id = idNext++;
            dbAtores.put(id,ator);
        }
    }

    public boolean containsAtor(Ator ator){
        for (Map.Entry<Long, Ator> atoresBanco : this.dbAtores.entrySet()) {
            if(atoresBanco.getValue().getNome().equalsIgnoreCase(ator.getNome())){
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(Long key) {
        return this.dbAtores.containsKey(key);
    }

    // public void removeAtores(String key) {
    //     data.remove(key);
    // }

}
