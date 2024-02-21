package view.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.FilmeController;
import models.Filme;
import models.Exceptions.InvalidResponse;
public class FilmeForm {

    private FilmeController filmeController;

    public FilmeForm(FilmeController filmeController) {
        this.filmeController = filmeController;
    }

    public void execute(Scanner scanner){
        try {
            System.out.print("Informe o Nome do Filme: ");
            String nome = scanner.nextLine();
            System.out.print("Informe o Ano de lançamento do Filme: ");
            Integer anoLancamento = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Informe o Estúdio do Filme: ");
            String estudio = scanner.nextLine();
            List<String> generos = new ArrayList<>();
            int contador = 1;
            System.out.println("Digite o Gênero do filme ou aperte Enter para terminar");
            while (true) {
                System.out.printf("%d° gênero do filme: ", contador);
                String strGenero = scanner.nextLine();
                contador++;
                if(strGenero.isBlank()){
                    break;
                }
                generos.add(strGenero);
            }
            System.out.print("Informe o score do Filme: ");
            Integer score = scanner.nextInt();
            scanner.nextLine();

            Filme filme = new Filme(nome, 
            anoLancamento, 
            null, 
            new ArrayList<>(),
            estudio, 
            generos, 
            score);
            try {
                this.filmeController.add(filme);
            } catch (InvalidResponse e) {
                System.out.println(e.getMessage());
                System.out.println("\nAperte ENTER para continuar");
                scanner.nextLine();
                return;
            }
            
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("\nAperte ENTER para continuar");
            scanner.nextLine();
            return;
        }

    }
}

