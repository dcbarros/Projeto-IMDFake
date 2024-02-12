package services;

import java.util.Map;

import models.Ator;
import repository.AtoresRepository;

public class AtorService {
    AtoresRepository _atoresRepository = AtoresRepository.getInstance();

    public Map<Long,Ator> getAtores(){
        Map<Long,Ator> atores = _atoresRepository.getTodos();
        if(atores.isEmpty()){
            return null;
        }
        return atores;
    }

    public void addAtor(Ator ator){
        if(ator != null){
            _atoresRepository.addAtor(ator);
        }
    }
}
