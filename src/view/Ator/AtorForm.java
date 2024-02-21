package view.Ator;

import java.util.Scanner;

import controller.AtorController;
import models.Ator;
import models.Exceptions.InvalidResponse;

public class AtorForm {
    private AtorController atorController;

    public AtorForm(AtorController atorController) {
        this.atorController = atorController;
    }

    public void execute(Scanner scanner){
        System.out.print("Informe o Nome do(a) Ator(ris): ");
        String nome = scanner.nextLine();
        System.out.print("Informe onde o(a) Ator(ris) nasceu: ");
        String paisOrigem = scanner.nextLine();
        Ator ator = new Ator(nome, paisOrigem);
        try{
            this.atorController.add(ator);
        }catch (InvalidResponse e){
            System.out.println(e.getMessage());
            System.out.println("\nAperte ENTER para continuar");
            scanner.nextLine();
            return;
        }
    }
}
