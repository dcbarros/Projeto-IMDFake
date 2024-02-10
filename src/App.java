import java.util.List;

import models.Ator;
import models.Filme;
import repository.AtoresRepository;
import repository.FilmesRepository;

public class App {
    public static void main(String[] args) throws Exception {
        FilmesRepository _filmesRepository = new FilmesRepository();
        AtoresRepository _atoresRepository = new AtoresRepository();

        // for (Filme f : _filmesRepository.getTodos()) {
        //     System.out.printf("%s - %s (%d) %d/100\n",f.getNome(), f.getEstudio(), f.getAnoLancamento(),f.getScore());
        //     System.out.printf("Dirigido por: %s (%s)\n",f.getDiretor().getNome(), f.getDiretor().getPaisOrigem());
        //     System.out.println("Estrelado por: ");
        //     for (Ator a : f.getAtores()) {
        //         System.out.printf("\t%s (%s)\n",a.getNome(), a.getPaisOrigem());
        //     }
        // }
        for (Ator a : _atoresRepository.getTodos()) {
            System.out.println(a.getNome());
        }
        Ator ator = new Ator("Teste", "Testando");
        _atoresRepository.adicionar(ator);
        System.err.println();
        for (Ator a : _atoresRepository.getTodos()) {
            System.out.println(a.getNome());
        }
        System.out.println();
        System.out.println(_atoresRepository.getPorId(0L).getProducoes().isEmpty());
        // for (Filme filme : producao) {
        //     System.out.println(filme.getNome());
        // }


    }
}
