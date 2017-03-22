package view;

import model.CodeType;
import model.Tabula;

import javax.swing.*;
import java.awt.*;


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
    private JLabel tabulaDesc = new JLabel("Tabula:");

    private JPanel edgePanel = new JPanel();
    private JPanel botomPanel = new JPanel();

    public MainWindow(){
        setLayout(new BorderLayout());
        edgePanel.setLayout(new GridLayout(1, 4));
        edgePanel.add(codeDesc);
        edgePanel.add(codes);
        edgePanel.add(tabulaDesc);
        edgePanel.add(tabulas);
        add(edgePanel, BorderLayout.EAST);

        botomPanel.add(encode);
        botomPanel.add(decode);
        add(botomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

}
