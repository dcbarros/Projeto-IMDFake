package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controller.AtorController;
import controller.DiretorController;
import controller.FilmeController;
import models.Ator;
import models.Diretor;
import models.Filme;

public class Console {

    FilmeController _filmeController = new FilmeController();
    AtorController _atorController = new AtorController();
    DiretorController _diretorController = new DiretorController();

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
                case 4:
                    limparTela();
                    addAtor();     
                    break; 
                case 5:
                    limparTela();
                    addDiretor();     
                    break; 
                case 6:
                    limparTela();
                    getTodosFilmes();
                    System.out.print("Digite o id do filme escolhido para associar o ator: ");
                    Long idFilmeAtor = scanner.nextLong();
                    scanner.nextLine();
                    Map<Long,Filme> filme = _filmeController.getFilmePorId(idFilmeAtor);
                    if(filme == null){
                        limparTela();
                        System.out.println("Filme não Cadastrado!");
                        break;
                    }
                    System.out.println();
                    listarAtoresPlataforma();
                    System.out.printf("Digite o id do(a) ator(ris) ao filme %s: ", filme.get(idFilmeAtor).getNome());
                    Long idAtor = scanner.nextLong();
                    scanner.nextLine();
                    addFilmeAoAtor(idAtor,filme.get(idFilmeAtor));
                    limparTela();
                    break;
                case 7:
                    limparTela();
                    getTodosFilmes();
                    System.out.print("Digite o id do filme escolhido para associar o ator: ");
                    Long idFilmeDiretor = scanner.nextLong();
                    scanner.nextLine();
                    Map<Long,Filme> filmeDiretor = _filmeController.getFilmePorId(idFilmeDiretor);
                    if(filmeDiretor == null){
                        limparTela();
                        System.out.println("Filme não Cadastrado!");
                        break;
                    }
                    System.out.println();
                    listarDiretoresPlataforma();
                    System.out.printf("Digite o id do(a) ator(ris) ao filme %s: ", filmeDiretor.get(idFilmeDiretor).getNome());
                    Long idDiretor = scanner.nextLong();
                    scanner.nextLine();
                    addFilmeAoDiretor(idDiretor, filmeDiretor.get(idFilmeDiretor));
                    limparTela();
                    break;
                case 8:
                    limparTela();
                    System.out.println("Obrigado!!!"); 
                    continuar = false;  
                    break;
                default:
                    System.out.println("Opção não existente");
                    break;   
            }
        }
        fecharScanner();
    }

    private void addFilmeAoAtor(Long idAtor, Filme filme){
        _filmeController.addFilmeAoAtor(idAtor, filme);
        limparTela();
        System.out.println("Associação Realizada com Sucesso!");
    }

    private void addFilmeAoDiretor(Long idDiretor, Filme filme){
        _filmeController.addFilmeAoDiretor(idDiretor, filme);
        limparTela();
        System.out.println("Associação Realizada com Sucesso!");
    }

    private void addAtor(){
        try {
            limparTela();
            listarAtoresPlataforma();
            System.out.print("Qual o nome completo do(a) ator(ris), caso não queira adicionar aperte ENTER: ");
            String nome = scanner.nextLine();
            if(!nome.isBlank()){
                System.out.print("Qual o pais que o(a) ator(ris) nasceu: ");
                String localNascimento = scanner.nextLine();
                Ator ator = new Ator(nome, localNascimento);
                _atorController.addAtor(ator);
            }
            limparTela();
        } catch (Exception e) {
            limparTela();
            System.out.println("Ocorreu um erro ao cadastrar o(a) ator(ris)");
        }
    }

    private void addDiretor(){
        try {
            limparTela();
            listarDiretoresPlataforma();
            System.out.print("Qual o nome completo do(a) diretor(a), caso não queira adicionar aperte ENTER: ");
            String nome = scanner.nextLine();
            if(!nome.isBlank()){
                System.out.print("Qual o pais que o(a) diretor(a) nasceu: ");
                String localNascimento = scanner.nextLine();
                Diretor diretor = new Diretor(nome, localNascimento);
                _diretorController.addDiretor(diretor);
            }
            limparTela();
        } catch (Exception e) {
            limparTela();
            System.out.println("Ocorreu um erro ao cadastrar o(a) diretor(a)");
        }
    }

    private void getFilme(String input){
        Map<Long, Filme> filmeEncontrado = _filmeController.getFilmePorNome(input);
        limparTela();
        System.out.println("Filmes Cadastrados \n");
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
            
            Filme filme = new Filme(nome, anoLancamento, null, new ArrayList<>(), estudio, generos, score);
            _filmeController.addFilme(filme);
            System.out.println("Filme adicionado com sucesso!");
        } catch (Exception e) {
            limparTela();
            System.out.println("Ocorreu um erro na hora de cadastrar o filme.");
        }
    }

    private void getTodosFilmes(){
        limparTela();
        Map<Long, Filme> filmesPlataforma = this._filmeController.getFilmes();
        System.out.println("Filmes Cadastrados\n");
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

    private void listarAtoresPlataforma(){
        Map<Long,Ator> atores = _atorController.getAtores();
        System.out.println("Lista de Atores Cadastrados");
        for (Map.Entry<Long,Ator> ator : atores.entrySet()) {
            System.out.printf("%d - %s\n", ator.getKey(), ator.getValue().getNome());
        }
        System.out.println();
    }

    private void listarDiretoresPlataforma(){
        Map<Long,Diretor> diretores = _diretorController.getDiretores();
        System.out.println("Lista de Diretores Cadastrados");
        for (Map.Entry<Long,Diretor> diretor : diretores.entrySet()) {
            System.out.printf("%d - %s\n", diretor.getKey(), diretor.getValue().getNome());
        }
        System.out.println();
    }
}
