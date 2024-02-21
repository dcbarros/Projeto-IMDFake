package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import db.DbModelRepository;
import models.Diretor;

public class DiretoresRepository extends AbstractRepository{

    public DiretoresRepository(DbModelRepository bancoDeDados) {
        super(bancoDeDados);
    }

    public List findByName(String nome){
        List atores = this.getAll();
        List diretorEncontrado = new ArrayList();
        for (Object object : atores) {
            Diretor ator = (Diretor) object;
            if(ator.getNome().equalsIgnoreCase(nome) 
            || ator.getNome().contains(nome)){
                diretorEncontrado.add(ator);
            }
        }
        return diretorEncontrado;
    }

    @Override
    protected Class ModelClass() {
        return Diretor.class;    
    }

    @Override
    protected Boolean idFilter(Object objeto, Long id) {
        Diretor diretor = (Diretor) objeto;
        return Objects.equals(diretor.getId(), id);
    }
    
}
