package services;

import java.util.Map;

import models.Ator;
import models.Diretor;
import repository.DiretoresRepository;



public class DiretorService {
        DiretoresRepository _diretoresRepository = DiretoresRepository.getInstance();

    public Map<Long,Diretor> getDiretores(){
        Map<Long,Diretor> diretores = _diretoresRepository.getTodos();
        if(diretores.isEmpty()){
            return null;
        }
        return diretores;
    }

    public void addDiretor(Diretor diretor){
        if(diretor != null){
            _diretoresRepository.addDiretor(diretor);
        }
    }
}
