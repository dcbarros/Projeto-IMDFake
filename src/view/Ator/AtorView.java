package view.Ator;

import controller.AtorController;
import view.AbstractConsole;

public class AtorView extends AbstractConsole{

    private AtorController atorController;

    public AtorView(AtorController atorController) {
        super(new String[]{
            "1 - Cadastrar",
            "2 - Listar",
            "3 - Buscar Ator pelo nome",
            "4 - Atribuir Filme",
            "5 - Voltar",
        });
        this.atorController = atorController;
    }

    @Override
    protected void executeOption(Integer option) {
        
        switch (option) {
            case 1:
                this.limparTela();
                new AtorForm(atorController).execute(this.scanner);
                break;
            case 2:
                this.limparTela();
                new AtorList(atorController).execute(this.scanner);
                break;
            case 3:
                this.limparTela();
                new AtorSearch(atorController).execute(this.scanner);
                break;
            case 5:
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
