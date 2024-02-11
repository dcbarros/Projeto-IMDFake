import java.util.Map;

import models.Diretor;
import models.Filme;
import repository.AtoresRepository;
import repository.DiretoresRepository;
import repository.FilmesRepository;

public class App {
    public static void main(String[] args) throws Exception {
        DiretoresRepository _diretoresRepository = DiretoresRepository.getInstance();
        FilmesRepository _filmesRepository = FilmesRepository.getInstance();
        AtoresRepository _atoresRepository = AtoresRepository.getInstance();

        for (Filme f : _diretoresRepository.getDiretorPorChave(1L).getProducoes()) {
            System.out.println(f.getNome());
        }
    }
}
