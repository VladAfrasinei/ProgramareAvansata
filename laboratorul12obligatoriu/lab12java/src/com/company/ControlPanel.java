package com.company;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class ControlPanel extends JPanel{

    DesignPanel control;
    MainFrame frame;
    public ControlPanel(MainFrame frame)
    {

        super(Boolean.parseBoolean("My Frame"));
        this.frame=frame;
        initializare();

    }

    private void initializare()
    {
        //Creeaza un nou frame, initial invizibil cu numele specificat.
        JFrame f = new JFrame("Flow Layout");
        JButton b;
        //Creeam un buton cu acest string
        b = new JButton("Swing component");
        //Adaugam butonul
        f.add(b);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setSize(400,400);
        b.setSize(150, 100);
        //Adaugam actiune
        control.button.addActionListener(actionListener);
    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == control) {
                try {
                    create();
                } catch (IOException e1) {
                    System.out.println(" ");
                }
            }
        }
    };

    private void create() throws IOException{
        control.addComponents();
    }

}
