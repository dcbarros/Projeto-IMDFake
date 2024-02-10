import java.util.List;

import models.Ator;
import repository.AtoresRepository;

public class App {
    public static void main(String[] args) throws Exception {
        AtoresRepository _atoresRespository = new AtoresRepository();

        List<Ator> teste = _atoresRespository.procurarPorNome("Tom");
        for (Ator ator : teste) {
            System.out.println(ator.getNome() + " " + ator.getSobrenome());
        }
    }
}
