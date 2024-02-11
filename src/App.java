// import java.util.Map;

// import repository.AtoresRepository;
// import repository.DiretoresRepository;
// import repository.FilmesRepository;

import view.Console;

public class App {
    public static void main(String[] args) throws Exception {

        Console console = new Console();
        console.menu();
        // DiretoresRepository _diretoresRepository = DiretoresRepository.getInstance();
        // FilmesRepository _filmesRepository = FilmesRepository.getInstance();
        // AtoresRepository _atoresRepository = AtoresRepository.getInstance();

        // // for (Filme f : _diretoresRepository.getDiretorPorChave(1L).getProducoes()) {
        // //     System.out.println(f.getNome());
        // // }

        // System.out.println(_atoresRepository.getAtorPorNome("Morgan Freeman"));
    }
}
