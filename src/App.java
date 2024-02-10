import java.util.List;

import models.Ator;
import repository.AtoresRepository;

public class App {
    public static void main(String[] args) throws Exception {
        AtoresRepository _atoresRespository = new AtoresRepository();
        
        for (Ator a : _atoresRespository.getTodos()) {
            System.out.println(a.getId() + " " + a.getNome());
        }

    }
}
