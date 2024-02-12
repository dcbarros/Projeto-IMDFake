package controller;

import java.util.Map;

import models.Diretor;
import services.DiretorService;

public class DiretorController {
    DiretorService _diretorService = new DiretorService();

    public Map<Long,Diretor> getDiretores(){
        return _diretorService.getDiretores();
    }

    public void addDiretor(Diretor diretor){
        _diretorService.addDiretor(diretor);
    }
}
