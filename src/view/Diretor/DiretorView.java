package view.Diretor;

import controller.DiretorController;
import view.AbstractConsole;

public class DiretorView extends AbstractConsole{

    private DiretorController diretorController;

    public DiretorView(DiretorController diretorController) {
        super(new String[]{
            "1 - Cadastrar",
            "2 - Listar",
            "3 - Buscar Diretor pelo nome",
            "4 - Voltar",
        });
        this.diretorController = diretorController;
    }

    @Override
    protected void executeOption(Integer option) {
        
        switch (option) {
            case 1:
                this.limparTela();
                new DiretorForm(diretorController).execute(this.scanner);
                break;
            case 2:
                this.limparTela();
                new DiretorList(diretorController).execute(this.scanner);
                break;
            case 3:
                this.limparTela();
                new DiretorSearch(diretorController).execute(this.scanner);
                break;
            case 4:
                this.limparTela();
                return;
            default:
                this.limparTela();
                System.out.println("Opção inválida");
                System.out.println("\nAperte ENTER para continuar");
                scanner.nextLine();
                execute();
                break;
        }
        execute();
        
    }
    
}
