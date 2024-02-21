package db;

import java.util.*;

public class DbModelRepository {

    private static final Map OBJETOS = new HashMap();

    public void inserirObjeto(Object objeto) {
        Set objetos = colecaoDeObjetos(objeto.getClass());
        objetos.add(objeto);
    }

    public void excluirObjeto(Object objeto) {
        Set objetos = colecaoDeObjetos(objeto.getClass());
        objetos.remove(objeto);
    }

    public List buscarObjetosPorTipo(Class clazz) {
        Set objetos = colecaoDeObjetos(clazz);
        return new ArrayList(objetos);
    }

    private Set colecaoDeObjetos(Class clazz) {
        Set objetos = (Set) DbModelRepository.OBJETOS.get(clazz);
        if (objetos == null){
            objetos = new HashSet();
            DbModelRepository.OBJETOS.put(clazz, objetos);
        }
        return objetos;
    }

}