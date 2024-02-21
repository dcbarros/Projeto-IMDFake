package view.Ator;

import java.util.List;
import java.util.Scanner;

import controller.AtorController;
import models.Ator;
import models.Filme;

public class AtorList {
    private AtorController atorController;

    public AtorList(AtorController atorController) {
        this.atorController = atorController;
    }

    public void execute(Scanner scanner){
        System.out.println("Lista de Artistas Cadastrados");
        List atoresLista = this.atorController.getAll();

        for (Object object : atoresLista) {
            Ator ator = (Ator) object;
            System.out.printf("%d - %s (%s)", ator.getId(), ator.getNome(), ator.getPaisOrigem());
            System.out.println("\nFilmografia: ");
            for (Filme filme : ator.getProducoes()) {
                System.out.printf("\t%d %s (%d)\n", filme.getId(), filme.getNome(), filme.getAnoLancamento());
            }
        }
        System.out.println("\nAperte ENTER para continuar");
        scanner.nextLine();
    }
}
