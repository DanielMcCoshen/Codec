package controler;

import view.MainWindow;

/**
 * Created by daniel on 22/03/17.
 */
public class startup {

    public static void main(String args[]){
       MainWindow window =  new MainWindow();
       GUIController controller = new GUIController(window);
       window.setController(controller);
    }
}
