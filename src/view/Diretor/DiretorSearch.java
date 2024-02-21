package view.Diretor;

import java.util.List;
import java.util.Scanner;


import controller.DiretorController;
import models.Diretor;
import models.Filme;
import models.Exceptions.InvalidResponse;

public class DiretorSearch {
    private DiretorController diretorController;

    public DiretorSearch(DiretorController diretorController) {
        this.diretorController = diretorController;
    }

    public void execute(Scanner scanner){
        System.out.print("Digite o nome do ator que você deseja buscar ou digite ENTER para voltar ao menu: ");
        String nome = scanner.nextLine();
        if(nome.isEmpty()){return;}
        try {
            List atoresEncontrados = this.diretorController.getDirectorByName(nome);
            System.out.println("\nAtores(rises) encontrados(as): ");
            for (Object object : atoresEncontrados) {
                Diretor diretor = (Diretor) object;
                System.out.printf("%d - %s (%s)", diretor.getId(), diretor.getNome(), diretor.getPaisOrigem());
                System.out.println("\nFilmografia: ");
                for (Filme filme : diretor.getProducoes()) {
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
