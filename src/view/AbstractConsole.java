package view;

import java.util.Scanner;


public abstract class AbstractConsole {

    protected Scanner scanner;
    private String[] options;

    public AbstractConsole(String[] options){
        this.options = options;
        this.scanner = new Scanner(System.in);
    } 

    public void execute(){
        this.limparTela();
        System.out.println("Escolha uma opção: ");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Qual a opção deseja passar? ");
        Integer option = this.scanner.nextInt();
        this.scanner.nextLine();
        if(validOption(option)){
            executeOption(option);
        }else{
            this.limparTela();
            System.out.println("Você digitou "+ option + " esta é uma opção inválida");
            System.out.println("\nAperte ENTER para continuar");
            this.scanner.nextLine();
            execute();
        }

    }

    protected Boolean validOption(Integer option){
        if(option < 0 || option > this.options.length){
            return false;
        }
        return true;
    }

    protected abstract void executeOption(Integer option);

    protected void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    protected void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

}
