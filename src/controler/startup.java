package controler;

import view.MainWindow;

/**
 * @author SigMa (Daniel McCoshen)
 * a startup class for the program
 */
public class startup {

    public static void main(String args[]){
        if (args.length ==0) {
            startGUI();
        }
    }

    private static void startGUI(){
        MainWindow window = new MainWindow();
        GUIController controller = new GUIController(window);
        window.setController(controller);
    }
}
