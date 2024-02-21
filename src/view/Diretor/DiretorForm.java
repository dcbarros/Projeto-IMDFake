package view.Diretor;

import java.util.Scanner;

import controller.DiretorController;
import models.Ator;
import models.Diretor;
import models.Exceptions.InvalidResponse;

public class DiretorForm {
    private DiretorController diretorController;

    public DiretorForm(DiretorController diretorController) {
        this.diretorController = diretorController;
    }

    public void execute(Scanner scanner){
        System.out.print("Informe o Nome do(a) Diretor(a): ");
        String nome = scanner.nextLine();
        System.out.print("Informe onde o(a) Diretor(a) nasceu: ");
        String paisOrigem = scanner.nextLine();
        Diretor diretor = new Diretor(nome, paisOrigem);
        try{
            this.diretorController.add(diretor);
        }catch (InvalidResponse e){
            System.out.println(e.getMessage());
            System.out.println("\nAperte ENTER para continuar");
            scanner.nextLine();
            return;
        }
    }
}
