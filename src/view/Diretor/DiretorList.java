package view.Diretor;

import java.util.List;
import java.util.Scanner;

import controller.AtorController;
import controller.DiretorController;
import models.Ator;
import models.Diretor;
import models.Filme;

public class DiretorList {
    private DiretorController diretorController;

    public DiretorList(DiretorController diretorController) {
        this.diretorController = diretorController;
    }
    
    public void execute(Scanner scanner){
        System.out.println("Lista de Diretores Cadastrados");
        List diretoresLista = this.diretorController.getAll();

        for (Object object : diretoresLista) {
            Diretor diretor = (Diretor) object;
            System.out.printf("%d - %s (%s)", diretor.getId(), diretor.getNome(), diretor.getPaisOrigem());
            System.out.println("\nFilmografia: ");
            for (Filme filme : diretor.getProducoes()) {
                System.out.printf("\t%d - %s (%d)\n", filme.getId(), filme.getNome(), filme.getAnoLancamento());
            }
        }
        System.out.println("\nAperte ENTER para continuar");
        scanner.nextLine();
    }
}
