import controller.AtorController;
import controller.DiretorController;
import controller.FilmeController;
import view.Menu;

public class App {
    public static void main(String[] args) throws Exception {

        AtorController atorController = new AtorController();
        DiretorController diretorController = new DiretorController();
        FilmeController filmeController = new FilmeController();
        
        Menu menu = new Menu(atorController, diretorController, filmeController);
        menu.execute();
    }
}
