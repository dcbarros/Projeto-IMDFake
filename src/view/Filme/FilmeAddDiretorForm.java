package view.Filme;

import java.util.Scanner;

import controller.DiretorController;
import controller.FilmeController;
import models.Exceptions.InvalidResponse;

public class FilmeAddDiretorForm {

    private FilmeController filmeController;
    private DiretorController diretorController;

    public FilmeAddDiretorForm(FilmeController filmeController, DiretorController diretorController) {
        this.filmeController = filmeController;
        this.diretorController = diretorController;
    }

    public void execute(Scanner scanner){

        System.out.println("Lista de filmes da plataforma");
        filmeController.listAllFilms();
        System.out.print("\nDigite o id do filme escolhido: ");
        Long filmeId = scanner.nextLong();
        scanner.nextLine();

        limparTela();
        System.out.println("Lista de diretores da plataforma");
        diretorController.listAllDirectos();
        System.out.print("\nDigite o id do diretor escolhido: ");
        Long diretorId = scanner.nextLong();
        scanner.nextLine();
        try {
            filmeController.update(filmeId, null, diretorController.getDiretorById(diretorId));
            diretorController.update(diretorId,filmeController.getFilmById(filmeId));
        } catch (InvalidResponse e) {
            System.err.println(e.getMessage());
            System.out.println("Aperte ENTER para continuar.");
            scanner.nextLine();
        }

    }

    private void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
