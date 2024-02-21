package repository;

import java.util.Collections;
import java.util.List;

import db.DbModelRepository;

public abstract class AbstractRepository {
    
    protected DbModelRepository bancoDeDados;

    public AbstractRepository(DbModelRepository bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public void add(Object object){
        this.bancoDeDados.inserirObjeto(object);
    }

    
    public Object findById(Long id){
        List objects = this.getAll();
        Object findObject = null;
        for (Object object : objects) {
            if(idFilter(object, id)){
                findObject = object;
            }
        }
        return findObject;
    }

    public List getAll(){
        List objectsInDB = this.bancoDeDados.buscarObjetosPorTipo(ModelClass());
        return Collections.unmodifiableList(objectsInDB);
    }

    public Boolean remove(Object object){
        this.bancoDeDados.excluirObjeto(object);
        return true;
    }

    protected abstract Class ModelClass();

    protected abstract Boolean idFilter(Object objeto, Long id);

}
