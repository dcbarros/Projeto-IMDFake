package view;

import java.time.LocalDateTime;

import controller.AtorController;
import controller.DiretorController;
import controller.FilmeController;
import view.Ator.AtorView;
import view.Diretor.DiretorView;
import view.Filme.FilmeView;

public class Menu extends AbstractConsole{

    private AtorController atorController;
    private DiretorController diretorController;
    private FilmeController filmeController;

    public Menu(AtorController atorController,
    DiretorController diretorController,
    FilmeController filmeController) {
        super(new String[] {
            "1 - Ator;",
            "2 - Diretor;",
            "3 - Filme",
            "4 - Sair"
        });
        this.atorController =  atorController;
        this.diretorController = diretorController;
        this.filmeController = filmeController;

        atorController.addMockData();
        diretorController.addMockData();
        filmeController.addMockData();

    }

    @Override
    protected void executeOption(Integer option) {
        
        switch (option) {
            case 1:
                this.limparTela();
                new AtorView(atorController).execute();
                break;
            case 2:
                this.limparTela();
                new DiretorView(diretorController).execute();
                break;
            case 3:
                this.limparTela();
                new FilmeView(filmeController, diretorController, atorController).execute();
                break;    
            case 4:
                this.limparTela();
                finalizacaoPrograma();
                break;       
            default:
                break;
        }
        execute();
    }

    private void finalizacaoPrograma(){
        Integer hora = LocalDateTime.now().getHour();
        String saudacao = (hora > 0 && hora < 12) ? "um Bom Dia!!" : (hora > 12 && hora < 18) ? "uma Boa Tarde!!" : "uma Boa Noite!!";
        System.out.printf("Obrigado, tenha %s", saudacao);
        this.fecharScanner();
        System.exit(1);
    }
    
}
