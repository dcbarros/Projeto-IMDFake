package services;

import java.util.Collections;
import java.util.List;

import db.DbModelRepository;
import models.Diretor;
import models.Filme;
import models.Exceptions.InvalidResponse;
import repository.DiretoresRepository;

public class DiretorService {
    private DiretoresRepository diretoresRepository;

    public DiretorService() {
        this.diretoresRepository = new DiretoresRepository(new DbModelRepository());
    }

    public void addDirector(Diretor diretor){
        if(diretor == null ||
            diretor.getNome().isBlank() ||
            diretor.getNome() == null
        ){
            throw new InvalidResponse("Diretor(a) deve ter um nome e não nulo");
        }
        if(diretoresRepository.findByName(diretor.getNome()).size() == 0){
            diretoresRepository.add(diretor);
            System.out.printf("Diretor %s inserido na base de dados\n", diretor.getNome());
        }else{
            throw new InvalidResponse("Diretor já cadastrado");
        }
    }

    public void update(Long id, Filme filme){
        if(id == null || filme == null || filme.getNome().isBlank() || filme.getAnoLancamento() == null){
            throw new InvalidResponse("O id ou o filme estao inválidos");
        }
        if(!filmContainsInDirectorList(id,filme)){
            Diretor diretor = (Diretor) diretoresRepository.findById(id);
            if(diretor == null){
                throw new InvalidResponse("O id não existe no banco de dados");
            }
            List<Filme> producoes = diretor.getProducoes();
            producoes.add(filme);
            diretor.setProducoes(producoes);
        }
    }

    public void listAllDirectos(){
        List<Diretor> diretores = diretoresRepository.getAll();
        for (Diretor diretor : diretores) {
            System.out.printf("%d - %s (%s)\n", diretor.getId(), diretor.getNome(), diretor.getPaisOrigem());
        }
    }

    public List getAllDirectors(){
        return Collections.unmodifiableList(diretoresRepository.getAll());
    }

    public List getDirectorByNome(String input){
        if(input.isBlank() || input == null){throw new InvalidResponse("O input deve possuir pelo menos um caractere");}
        List diretores = diretoresRepository.findByName(input);
        return diretores;
    }
    public Diretor getDirectorById(Long id){
        if(id == null){
            throw new InvalidResponse("Id inválido");
        }
        Diretor diretor = (Diretor) diretoresRepository.findById(id);
        if(diretor == null){
            throw new InvalidResponse("Diretor não encontrado!");
        }
        return diretor;
    }

    public void addMockerData(){
        Diretor diretor1 = new Diretor("Christopher Nolan", "Inglaterra");
        addDirector(diretor1);
    }

    private Boolean filmContainsInDirectorList(Long id, Filme filme){
        Diretor diretor = (Diretor) diretoresRepository.findById(id);
        for (Filme producao : diretor.getProducoes()) {
            if(producao.getNome().equalsIgnoreCase(filme.getNome()) && producao.getAnoLancamento().equals(filme.getAnoLancamento())){
                return true;
            }
        }
        return false;
    }
}
