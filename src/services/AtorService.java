package services;

import java.util.Collections;
import java.util.List;

import db.DbModelRepository;
import models.Ator;
import models.Diretor;
import models.Filme;
import models.Exceptions.InvalidResponse;
import repository.AtoresRepository;

public class AtorService {
    
    private AtoresRepository atoresRepository;

    public AtorService() {
        this.atoresRepository = new AtoresRepository(new DbModelRepository());
    }

    public void listAllActors(){
        List<Ator> atores = atoresRepository.getAll();
        for (Ator ator : atores) {
            System.out.printf("%d - %s (%s)\n", ator.getId(), ator.getNome(), ator.getPaisOrigem());
        }
    }

    public List getAllActors(){
        return Collections.unmodifiableList(atoresRepository.getAll());
    }

    public List getActorByNome(String input){
        if(input.isBlank() || input == null){throw new InvalidResponse("O input deve possuir pelo menos um caractere");}
        List atores = atoresRepository.findByName(input);
        return atores;
    }
    
    public Ator getActorById(Long id){
        if(id == null){throw new InvalidResponse("Id inválido");}
        Ator ator = (Ator) atoresRepository.findById(id);
        if(ator == null){throw new InvalidResponse("Ator não encontrado!");}
        return ator;
    }

    public void addActor(Ator ator){
        if(ator == null || ator.getNome() == null || ator.getNome().isBlank()){
            throw new InvalidResponse("O(A) ator(ris) não pode ser nulo");
        }
        if(atoresRepository.findByName(ator.getNome()) == null){
            atoresRepository.add(ator);
            System.out.printf("Ator %s inserido na base de dados\n", ator.getNome());
        }else{
            throw new InvalidResponse("Ator já cadastrado");
        }
    }

    public void update (Long id, Filme filme){
        if(id == null || filme == null || filme.getNome().isBlank() || filme.getAnoLancamento() == null)
        {throw new InvalidResponse("O id ou o filme estao inválidos");}
        if(!filmContainsInActorList(id,filme)){
            Ator ator = (Ator) atoresRepository.findById(id);
            if(ator == null){throw new InvalidResponse("O id não existe no banco de dados");}
            List<Filme> producoes = ator.getProducoes();
            producoes.add(filme);
            ator.setProducoes(producoes);
        }

    }
    public void addMockerData(){
        Ator ator1 = new Ator(
            "Cillian Murphy", 
            "Irlânda");    
        atoresRepository.add(ator1);
        Ator ator2 = new Ator(
            "Emily Blunt",
             "Inglaterra");
             atoresRepository.add(ator2);
        Ator ator3 = new Ator(
                "Matt Damon",
                 "Estados Unidos");
        atoresRepository.add(ator3);
    }

        private Boolean filmContainsInActorList(Long id, Filme filme){
        Ator ator = (Ator) atoresRepository.findById(id);
        for (Filme producao : ator.getProducoes()) {
            if(producao.getNome().equalsIgnoreCase(filme.getNome()) && producao.getAnoLancamento().equals(filme.getAnoLancamento())){
                return true;
            }
        }
        return false;
    }

}
