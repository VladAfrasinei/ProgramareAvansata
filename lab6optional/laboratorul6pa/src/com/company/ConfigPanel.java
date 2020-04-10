package com.company;
import javax . swing .*;
import java.awt.*;
import java.util.Random;
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JLabel label1;
    JLabel label2;
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape
    JComboBox shapeCombo;
    JComboBox toolCombo;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        label2=new JLabel("Tools:");
        label = new JLabel("Colors:");
        label1=new JLabel("Shapes:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        //create the colorCombo, containing the values: Random and Black
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        //Aici am creat culoarea random
        Color randomColor = new Color(r, g, b);
        Color black=new Color(0,0,0);
        String[] colors={"Random","Black"};
        colorCombo=new JComboBox<>(colors);
        colorCombo.setSelectedIndex(0);
        String[] shapes={"Romb","Cerc","Pentagon","Hexagon","Heptagon","Octogon"};
        shapeCombo=new JComboBox<>(shapes);
        shapeCombo.setSelectedIndex(0);
        String[] tools={"Paint","Retain"};
        toolCombo=new JComboBox<>(tools);
        toolCombo.setSelectedIndex(0);
        //colorCombo.addItem(randomColor);
        //colorCombo.addItem(black);
        add(label2);
        add(toolCombo);
        add(label); //JPanel uses FlowLayout by default
        //add(sidesField);
        add(colorCombo);
        add(label1);
        add(shapeCombo);
    }
}
