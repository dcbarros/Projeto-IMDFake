package view.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.AtorController;
import controller.FilmeController;
import models.Ator;
import models.Exceptions.InvalidResponse;

public class FilmeAddActorForm {
    private FilmeController filmeController;
    private AtorController atorController;

    public FilmeAddActorForm(FilmeController filmeController, AtorController atorController) {
        this.filmeController = filmeController;
        this.atorController = atorController;
    }

    public void execute(Scanner scanner){
        System.out.println("Lista de filmes da plataforma");
        filmeController.listAllFilms();
        System.out.print("\nDigite o id do filme escolhido: ");
        Long filmeId = scanner.nextLong();
        scanner.nextLine();

        limparTela();
        List<Ator> atores = new ArrayList<>();
        System.out.println("Lista de atores da plataforma");
        atorController.listAllActors();
        while(true){
            System.out.print("\nDigite o id do ator escolhido, se deseja parar digite 0: ");
            Long atorId = scanner.nextLong();
            scanner.nextLine();
            if(atorId == 0){break;}
            atores.add(atorController.getActorById(atorId));
            try {
                atorController.update(atorId, filmeController.getFilmById(filmeId));
            } catch (InvalidResponse e) {
                System.err.println(e.getMessage());
                System.out.println("Aperte ENTER para continuar.");
                scanner.nextLine();
                break;
            }  
        }
        try {
            filmeController.update(filmeId, atores, null);      
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
