package view.Filme;

import java.util.List;
import java.util.Scanner;

import controller.FilmeController;
import models.Ator;
import models.Filme;

public class FilmeList {
    private FilmeController filmeController;

    public FilmeList(FilmeController filmeController){
        this.filmeController = filmeController;
    }

    public void execute(Scanner scanner){
        System.out.println("Lista de Filmes Cadastrados");
        List filmeLista = this.filmeController.getAll();

        for (Object object : filmeLista) {
            Filme filme = (Filme) object;
            System.out.printf("%d - %s (%d) Estúdio: %s %d/100", filme.getId(), filme.getNome(), filme.getAnoLancamento(), filme.getEstudio(), filme.getScore());
            if(filme.getDiretor() == null){
                System.out.printf("\n\tDirigido por: Não encontrado");
            }else{
                System.out.printf("\n\tDirigido por: %s (%s)", filme.getDiretor().getNome(), filme.getDiretor().getPaisOrigem());
            }
            System.out.println("\n\tEstrelado por: ");
            for (Ator ator : filme.getAtores()) {
                System.out.printf("\t%d - %s (%s)\n", ator.getId(), ator.getNome(), ator.getPaisOrigem());
            }
        }

        System.out.println("\nAperte ENTER para continuar");
        scanner.nextLine();
    }
}
