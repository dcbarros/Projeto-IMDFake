package view;

public class Console {

    private static void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



    public void menu(){
        limparTela();
        System.out.printf("%25s Bem Vindo ao IMDFake %20s\n\n", "", "");
        System.out.printf(
            "1 - Listar os filmes da plataforma %9s 2 - Buscar por filme" + 
            "\n3 - Cadastrar filme %24s 4 - Cadastrar Ator" + 
            "\n5 - Cadastrar Diretor %23s6 - Associar Filme ao Ator"+ 
            "\n7 - Associar Filme ao Diretor %15s8 - Sair",
            "","","","");
        System.out.println("\n\nEscolha a opção: ");
    }
}
