package services;

import java.util.Map;

import models.Diretor;
import repository.DiretoresRepository;



public class DiretorService {
        DiretoresRepository _diretoresRepository = DiretoresRepository.getInstance();

    public Map<Long,Diretor> getAtores(){
        Map<Long,Diretor> diretores = _diretoresRepository.getTodos();
        if(diretores.isEmpty()){
            return null;
        }
        return diretores;
    }
}
