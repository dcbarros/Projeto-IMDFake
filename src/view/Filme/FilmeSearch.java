package view.Filme;

import java.util.List;
import java.util.Scanner;

import controller.FilmeController;
import models.Filme;
import models.Exceptions.InvalidResponse;

public class FilmeSearch {

    private FilmeController filmeController;

    public FilmeSearch(FilmeController filmeController) {
        this.filmeController = filmeController;
    }

    public void execute(Scanner scanner){
        System.out.print("Digite o nome do Filme que você deseja buscar ou digite ENTER para voltar ao menu: ");
        String nome = scanner.nextLine();
        if(nome.isEmpty()){return;}

        try {
            List atoresEncontrados = this.filmeController.getFilmByName(nome);
            System.out.println("\nFilmes encontrados: ");
            for (Object object : atoresEncontrados) {
                Filme filme = (Filme) object;
                System.out.printf("%d - %s (%d)", filme.getId(), filme.getNome(), filme.getAnoLancamento());
                System.out.println("\nGêneros: ");
                for (String genero : filme.getGenero()) {
                    System.out.println("\t"+genero);
                }
            }
            System.out.println("\nAperte ENTER para continuar");
            scanner.nextLine();
        } catch (InvalidResponse e) {
            System.out.println(e.getMessage());
            System.out.println("\nAperte ENTER para continuar");
            scanner.nextLine();
            return;
        }
    }
    
}
