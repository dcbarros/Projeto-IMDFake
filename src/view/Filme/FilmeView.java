package view.Filme;

import controller.AtorController;
import controller.DiretorController;
import controller.FilmeController;
import view.AbstractConsole;


public class FilmeView extends AbstractConsole{
    

    private AtorController atorController;
    private DiretorController diretorController;
    private FilmeController filmeController;

    public FilmeView(FilmeController filmeController,
    DiretorController diretorController,
    AtorController atorController) {
        super(new String[]{
            "1 - Cadastrar",
            "2 - Listar",
            "3 - Buscar Filme pelo nome",
            "4 - Adicionar diretor ao Cast de um filme",
            "5 - Adicionar atores ao Cast de um filme",
            "6 - Ranking de Filmes",
            "7 - Voltar",
        });
        this.atorController = atorController;
        this.diretorController = diretorController;
        this.filmeController = filmeController;
    }
 

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1:
                this.limparTela();
                new FilmeForm(filmeController).execute(scanner);
                break;
            case 2:
                this.limparTela();
                new FilmeList(filmeController).execute(scanner,false);
                break;
            case 3:
                this.limparTela();
                new FilmeSearch(filmeController).execute(scanner);
                break;
            case 4:
                this.limparTela();
                new FilmeAddDiretorForm(filmeController, diretorController).execute(scanner);
                break;
            case 5:
                this.limparTela();
                new FilmeAddActorForm(filmeController, atorController).execute(scanner);
                break;
            case 6:
                this.limparTela();
                new FilmeList(filmeController).execute(scanner,true);
                break;
            case 7:
                this.limparTela();
                return;
            default:
                this.limparTela();
                System.out.println("Opção inválida");
                System.out.println("\nAperte ENTER para continuar");
                this.scanner.nextLine();
                execute();
                break;
        }
        execute();
    }
    
}
