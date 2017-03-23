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

    private JTextField infile = new JTextField(10);
    private JTextField outfile = new JTextField(10);

    private JLabel inputDesc = new JLabel("Message:");
    private JLabel codeDesc = new JLabel("Code:");
    private JLabel tabulaDesc = new JLabel("Tabula:");
    private JButton infileDesc = new JButton("Input File (Optional):");
    private JButton outfileDesc = new JButton("Output File (Optional):");

    private JPanel edgePanel = new JPanel();
    private JPanel botomPanel = new JPanel();

    public MainWindow(){
        setLayout(new BorderLayout());
        edgePanel.setLayout(new GridLayout(4, 1));
        edgePanel.add(codeDesc);
        edgePanel.add(codes);
        edgePanel.add(tabulaDesc);
        edgePanel.add(tabulas);
        add(edgePanel, BorderLayout.EAST);

        botomPanel.add(infileDesc);
        botomPanel.add(infile);
        botomPanel.add(outfileDesc);
        botomPanel.add(outfile);
        botomPanel.add(encode);
        botomPanel.add(decode);
        add(botomPanel, BorderLayout.SOUTH);

        add(inputDesc, BorderLayout.NORTH);
        add(input, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(850,300);
        setVisible(true);
    }

}
