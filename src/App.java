import java.util.Map;

import models.Ator;
import repository.AtoresRepository;

public class App {
    public static void main(String[] args) throws Exception {
        AtoresRepository _AtoresRepository = AtoresRepository.getInstance();
        _AtoresRepository.addAtor(new Ator("Pedro de Lara","Brasil"));
        _AtoresRepository.addAtor(new Ator("Pedro de Lara","Brasil"));
        _AtoresRepository.addAtor(new Ator("Juininho","Brasil"));
        for (Map.Entry<Long, Ator> entry : _AtoresRepository.getTodos().entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue().getNome());
        }
    }
}
