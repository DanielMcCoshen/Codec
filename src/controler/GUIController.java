package controler;

import model.CodeType;
import model.Tabula;
import view.MainWindow;

/**
 * Created by daniel on 22/03/17.
 */
public class GUIController {

    private MainWindow window;

    public GUIController(MainWindow window){
        this.window = window;
        window.addCode(new CodeType("Test Code Type"));

    }

    public void encode(){
        CodeType code = window.getCode();
        Tabula tab = window.getTabula();
        code.setTab(tab);

        String message = window.getInput();
        String key = window.getKey();

        window.setOut(code.encode(message, key));
    }

    public void decode(){
        CodeType code = window.getCode();
        Tabula tab = window.getTabula();
        code.setTab(tab);

        String message = window.getInput();
        String key = window.getKey();

        window.setOut(code.decode(message, key));
    }
}
