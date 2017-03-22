package view;

import model.CodeType;
import model.Tabula;

import javax.swing.*;

/**
 * Created by daniel on 22/03/17.
 */
public class MainWindow extends JFrame {

    private JButton encode = new JButton("Encode");
    private JButton decode = new JButton("Decode");

    private JTextArea input = new JTextArea("");

    private JComboBox<CodeType> codes = new JComboBox<>();
    private JComboBox<Tabula> tabulas = new JComboBox<>();

    private JLabel inputDesc = new JLabel("Enter Message");
    private JLabel codeDesc = new JLabel("Code:");
    private JLabel tabulaDesc = new JLabel()

    public MainWindow(){

    }

}
