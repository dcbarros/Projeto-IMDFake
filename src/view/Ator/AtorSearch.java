package view.Ator;

import java.util.List;
import java.util.Scanner;

import controller.AtorController;
import models.Ator;
import models.Filme;
import models.Exceptions.InvalidResponse;

public class AtorSearch {
    private AtorController atorController;

    public AtorSearch(AtorController atorController) {
        this.atorController = atorController;
    }

    public void execute(Scanner scanner){
        System.out.print("Digite o nome do ator que você deseja buscar ou digite ENTER para voltar ao menu: ");
        String nome = scanner.nextLine();
        if(nome.isEmpty()){return;}
        try {
            List atoresEncontrados = this.atorController.getActorByName(nome);
            System.out.println("\nAtores(rises) encontrados(as): ");
            for (Object object : atoresEncontrados) {
                Ator ator = (Ator) object;
                System.out.printf("%d - %s (%s)", ator.getId(), ator.getNome(), ator.getPaisOrigem());
                System.out.println("\nFilmografia: ");
                for (Filme filme : ator.getProducoes()) {
                    System.out.printf("\t%d %s (%d)\n", filme.getId(), filme.getNome(), filme.getAnoLancamento());
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
