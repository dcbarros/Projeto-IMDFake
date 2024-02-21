package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import db.DbModelRepository;
import models.Filme;

public class FilmesRepository extends AbstractRepository{

    public FilmesRepository(DbModelRepository bancoDeDados) {
        super(bancoDeDados);
    }

    public List findByName(String nome){
        List atores = this.getAll();
        List filmeEncontrado = new ArrayList();
        for (Object object : atores) {
            Filme ator = (Filme) object;
            if(ator.getNome().equalsIgnoreCase(nome) 
            || ator.getNome().contains(nome)){
                filmeEncontrado.add(ator);
            }
        }
        return filmeEncontrado;
    }


    @Override
    protected Class ModelClass() {
        return Filme.class;
    }

    @Override
    protected Boolean idFilter(Object objeto, Long id) {
        Filme filme = (Filme) objeto;
        return Objects.equals(filme.getId(), id);
    }
    
}
