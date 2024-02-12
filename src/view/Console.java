package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controller.FilmeController;
import models.Ator;
import models.Filme;

public class Console {

    FilmeController _filmeController = new FilmeController();
    private Scanner scanner;

    private void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

    public void menu(){
        Boolean continuar = true;
        limparTela();
        while (continuar) {
            scanner = new Scanner(System.in);
            System.out.printf("%25s Bem Vindo ao IMDFake %20s\n\n", "", "");
            System.out.printf(
                "1 - Listar os filmes da plataforma %9s 2 - Buscar por filme" + 
                "\n3 - Cadastrar filme %24s 4 - Cadastrar Ator" + 
                "\n5 - Cadastrar Diretor %23s6 - Associar Filme ao Ator"+ 
                "\n7 - Associar Filme ao Diretor %15s8 - Sair",
                "","","","");
            System.out.print("\n\nEscolha a opção: ");
            Integer opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    limparTela();
                    getTodosFilmes();          
                    break;
                case 2:
                    limparTela();
                    System.out.print("Qual o nome do Filme que deseja encontrar? ");
                    String strFilme = scanner.nextLine();
                    getFilme(strFilme);      
                    break;  
                case 3:
                    limparTela();
                    addFilme();          
                    break;  
                case 8:
                    limparTela();
                    System.out.println("Obrigado!!!"); 
                    continuar = false;  
                    break;
                default:
                    break;   
            }
        }
        fecharScanner();
    }

    private void getFilme(String input){
        Map<Long, Filme> filmeEncontrado = _filmeController.getFilmePorNome(input);
        limparTela();
        if(input.isBlank()){
            System.out.println("O nome do filme deve ser diferente de vazio.");
            limparTela();
        }
        if(filmeEncontrado != null){
            limparTela();
            for (Map.Entry<Long, Filme> filmeSet : filmeEncontrado.entrySet()) {
                Filme filme = filmeSet.getValue();
                System.out.printf("%d - %s (%s)  %d/100\n", filmeSet.getKey(),filme.getNome(),filme.getEstudio(), filme.getScore());
                System.out.print("Gênero(s): ");
                for (String genero : filme.getGenero()) {
                    System.out.print(genero + " ");
                }
                System.out.println();
                if(filme.getDiretor() == null){
                    System.out.println("Dirigido por: Diretor não encontrado.");
                }else{
                    System.out.printf("Dirigido por: %s (%s)\n",filme.getDiretor().getNome(),filme.getDiretor().getPaisOrigem());
                }
                try {
                    System.out.println("Estrelado por: ");
                    for (Ator ator : filme.getAtores()) {
                        System.out.printf("\t%s (%s)\n", ator.getNome(), ator.getPaisOrigem());
                    }
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("Estrelado por: Atores não encontrados.");
                }
            }
            System.out.println("\nClique em qualquer tecla para continuar.");
            scanner.nextLine();
            limparTela();
        }else{
            limparTela();
            System.out.println("Filme não encontrado");
        }
    }

    private void getTodosFilmes(){
        limparTela();
        Map<Long, Filme> filmesPlataforma = this._filmeController.getFilmes();
        for (Map.Entry<Long, Filme> filmeSet : filmesPlataforma.entrySet()) {
            Filme filme = filmeSet.getValue();
            System.out.printf("%d - %s (%s)  %d/100\n", filmeSet.getKey(),filme.getNome(),filme.getEstudio(), filme.getScore());
            if(filme.getDiretor() == null){
                System.out.println("Dirigido por: Diretor não encontrado.");
            }else{
                System.out.printf("Dirigido por: %s (%s)\n",filme.getDiretor().getNome(),filme.getDiretor().getPaisOrigem());
            }
            try {
                System.out.println("Estrelado por: ");
                for (Ator ator : filme.getAtores()) {
                    System.out.printf("\t%s (%s)\n", ator.getNome(), ator.getPaisOrigem());
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println("Estrelado por: Atores não encontrados.");
            }
        }
        System.out.println("\nClique em qualquer tecla para continuar.");
        scanner.nextLine();
        limparTela();
    }

    private void addFilme(){
        try {
            limparTela();
            System.out.println("Cadastro de Filmes\n\n");
            System.out.print("Digite o Nome do Filme: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o Ano de Lançamento do Filme: ");
            Integer anoLancamento = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o Nome do Estúdio: ");
            String estudio = scanner.nextLine();
            System.out.print("Digite o Score do Filme na Plataforma: ");
            Integer score = scanner.nextInt();
            scanner.nextLine();
            Integer auxiliar = 1;
            String opcaoGenero;
            List<String> generos = new ArrayList<>();
            while(true){
                System.out.printf("Digite o %d° gênero do filme, se quiser terminar a lista é só apertar Enter: ", auxiliar);
                opcaoGenero = scanner.nextLine();
                if(opcaoGenero.isEmpty()){
                    break;
                }
                auxiliar++;
                generos.add(opcaoGenero);
            }
            
            Filme filme = new Filme(nome, anoLancamento, null, null, estudio, generos, score);
            _filmeController.addFilme(filme);
            System.out.println("Filme adicionado com sucesso!");
        } catch (Exception e) {
            limparTela();
            System.out.println("Ocorreu um erro na hora de cadastrar o filme.");
        }
    }
}
