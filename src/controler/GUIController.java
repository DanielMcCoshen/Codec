package controler;

import model.CodeType;
import model.Tabula;
import view.MainWindow;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;

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

        String message = determineInput();
        String key = determinekey();
        String outFile = window.getOutFile();

        String done = code.encode(message, key);
        window.setOut(done);

        if (outFile != ""){
            try(  PrintWriter out = new PrintWriter(outFile)  ){
                out.println(done);
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(window, "output file not found");
                throw new RuntimeException("output file not found");
            }
        }
    }

    public void decode(){
        CodeType code = window.getCode();
        Tabula tab = window.getTabula();
        code.setTab(tab);

        String message = determineInput();
        String key = determinekey();
        String outFile = window.getOutFile();

        String done = code.decode(message, key);
        window.setOut(done);

        if (outFile != ""){
            try(  PrintWriter out = new PrintWriter(outFile)  ){
                out.println(done);
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(window, "output file not found");
                throw new RuntimeException("output file not found");
            }
        }
    }

    private String determineInput(){
        String fromWindow = window.getInput();
        String filepath = window.getInFile();

        if (!filepath.equals("") && !fromWindow.equals("")){
            JOptionPane.showMessageDialog(window, "Both file input and direct input defined.");
            throw new RuntimeException("Both file input and direct input defined");
        }
        else if (!filepath.equals("")){
            try {
                return readFile(filepath, StandardCharsets.UTF_8);
            }
            catch (IOException e){
                JOptionPane.showMessageDialog(window, "Input file Not Found");
            }
        }
        else if (!fromWindow.equals("")){
            return fromWindow;
        }
        else if (filepath.equals("") && fromWindow.equals("")){
           JOptionPane.showMessageDialog(window, "no input defined");
            throw new RuntimeException("No input defined");
        }
        else {
            throw new RuntimeException("UNKNOWN ERROR");
        }
        return "";
    }
    private String determinekey(){
        String fromWindow = window.getKey();
        String filepath = window.getKeyFile();

        if (!filepath.equals("") && !fromWindow.equals("")){
            JOptionPane.showMessageDialog(window, "Both file key and direct key defined.");
            throw new RuntimeException("Both file input and direct input defined");
        }
        else if (!filepath.equals("")){
            try {
                return readFile(filepath, StandardCharsets.UTF_8);
            }
            catch (IOException e){
                JOptionPane.showMessageDialog(window, "Key file Not Found");
            }
        }
        else if (!fromWindow.equals("")){
            return fromWindow;
        }
        else if (filepath.equals("") && fromWindow.equals("")){
            JOptionPane.showMessageDialog(window, "no key defined");
            throw new RuntimeException("No key defined");
        }
        else {
            throw new RuntimeException("UNKNOWN ERROR");
        }
        return "";
    }

    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
