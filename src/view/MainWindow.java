package view;

import controler.GUIController;
import model.CodeType;
import model.Tabula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by daniel on 22/03/17.
 */
public class MainWindow extends JFrame {

    private JButton encode = new JButton("Encode");
    private JButton decode = new JButton("Decode");

    private JTextArea input = new JTextArea(15,33);
    private JTextArea key = new JTextArea(15,33);
    private JScrollPane inputPane = new JScrollPane(input);
    private JScrollPane keyPane = new JScrollPane(key);

    private JComboBox<CodeType> codes = new JComboBox<>();
    private JComboBox<Tabula> tabulas = new JComboBox<>();

    private JTextField infile = new JTextField(10);
    private JTextField outfile = new JTextField(10);
    private JTextField keyfile = new JTextField(10);

    private JLabel inputDesc = new JLabel("Message:");
    private JLabel keyDesc = new JLabel("Key:");
    private JLabel codeDesc = new JLabel("Code:");
    private JLabel tabulaDesc = new JLabel("Tabula:");

    private JButton infileDesc = new JButton("Input File (Optional):");
    private JButton outfileDesc = new JButton("Output File (Optional):");
    private JButton keyFileDesc = new JButton("KeyFile (Optional)");

    private JPanel edgePanel = new JPanel();
    private JPanel botomPanel = new JPanel();
    private JPanel centrePanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel anotherCentrePanel = new JPanel();


    private GUIController controller;

    public MainWindow(){


        //GUI SETUP
        key.setLineWrap(true);
        key.setAutoscrolls(true);
        input.setLineWrap(true);
        input.setAutoscrolls(true);

        setLayout(new BorderLayout());
        edgePanel.setLayout(new GridLayout(6, 1));
        edgePanel.add(codeDesc);
        edgePanel.add(codes);
        edgePanel.add(tabulaDesc);
        edgePanel.add(tabulas);
        edgePanel.add(encode);
        edgePanel.add(decode);
        add(edgePanel, BorderLayout.EAST);

        botomPanel.add(infileDesc);
        botomPanel.add(infile);
        botomPanel.add(outfileDesc);
        botomPanel.add(outfile);
        botomPanel.add(keyFileDesc);
        botomPanel.add(keyfile);
        add(botomPanel, BorderLayout.SOUTH);

        centrePanel.setLayout(new BoxLayout(centrePanel,BoxLayout.PAGE_AXIS));
        centrePanel.add(keyDesc);
        centrePanel.add(keyPane);
        anotherCentrePanel.add(centrePanel);

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.add(inputDesc);
        leftPanel.add(inputPane);
        anotherCentrePanel.add(leftPanel);

        add(anotherCentrePanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //LISTENER SETUP
        encode.addActionListener(actionEvent -> controller.encode());
        decode.addActionListener(actionEvent -> controller.decode());
        keyFileDesc.addActionListener(actionEvent -> {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);
            keyfile.setText(file.getSelectedFile().getAbsolutePath());
        });
        infileDesc.addActionListener(actionEvent -> {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);
            infile.setText(file.getSelectedFile().getAbsolutePath());
        });
        outfileDesc.addActionListener(actionEvent -> {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);
            outfile.setText(file.getSelectedFile().getAbsolutePath());
        });



        setSize(910,300);
        setVisible(true);
    }

    public void setController(GUIController controller) {
        this.controller = controller;
    }

    public String getInput(){
        return input.getText();
    }
    public String getKey(){
        return key.getText();
    }
    public String getKeyFile(){
        return keyfile.getText();
    }
    public String getInFile(){
        return infile.getText();
    }
    public String getOutFile(){
        return outfile.getText();
    }
    public void setOut(String message){
        input.setText(message);
    }
    public void addCode(CodeType code){
        codes.addItem(code);
    }
    public void addTabula(Tabula tab){
        tabulas.addItem(tab);
    }
    public CodeType getCode(){
        return (CodeType)codes.getSelectedItem();
    }
    public Tabula getTabula(){
        return (Tabula)tabulas.getSelectedItem();
    }
}
