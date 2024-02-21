package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import db.DbModelRepository;
import models.Ator;
import models.Exceptions.InvalidResponse;

public class AtoresRepository extends AbstractRepository{

    public AtoresRepository(DbModelRepository bancoDeDados) {
        super(bancoDeDados);
    }

    public List findByName(String nome){
        List atores = this.getAll();
        List atorEncontrado = new ArrayList();
        for (Object object : atores) {
            Ator ator = (Ator) object;
            if(ator.getNome().equalsIgnoreCase(nome) 
            || ator.getNome().toLowerCase().contains(nome.toLowerCase())){
                atorEncontrado.add(ator);
            }
        }
        if(atorEncontrado.size() == 0){return null;}
        return atorEncontrado;
    }

    @Override
    protected Class ModelClass() {
        return Ator.class;    
    }

    @Override
    protected Boolean idFilter(Object objeto, Long id) {
        Ator ator = (Ator) objeto;
        return Objects.equals(ator.getId(), id);
    }
    
}
