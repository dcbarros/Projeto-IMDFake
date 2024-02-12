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
        while (continuar) {
            limparTela();
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
                    getTodosFilmes();          
                    break;  
                case 3:
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

    private void getTodosFilmes(){
        limparTela();
        Map<Long, Filme> filmesPlataforma = this._filmeController.getFilmes();
        for (Map.Entry<Long, Filme> filmeSet : filmesPlataforma.entrySet()) {
            Filme filme = filmeSet.getValue();
            System.out.printf("%d - %s (%s)  %d/100\n", filmeSet.getKey(),filme.getNome(),filme.getEstudio(), filme.getScore());
            if(filme.getDiretor()==null){
                System.out.println("Dirigido por: Diretor não encontrado.");
            }else{
                System.out.printf("Dirigido por: %s (%s)\n",filme.getDiretor().getNome(),filme.getDiretor().getPaisOrigem());
            }
            if(filme.getAtores() == null){
                System.out.println("Estrelado por: Atores não encontrados.");
            }else{
                for (Ator ator : filme.getAtores()) {
                    System.out.printf("\t%s (%s)\n", ator.getNome(), ator.getPaisOrigem());
                }
                System.out.println();
            }
        }
        System.out.println("\n\nClique em qualquer tecla para continuar.");
        scanner.nextLine();
    }

    private void addFilme(){
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
    }
}
