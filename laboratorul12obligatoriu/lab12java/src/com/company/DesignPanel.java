package com.company;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;

public class DesignPanel extends JPanel {
    public AbstractButton button;
    JTextField component;
    MainFrame frame;
    void DesignPanel(MainFrame frame){
        this.frame=frame;
        addComponents();
    }
    void addComponents(){
        ControlPanel control=new ControlPanel(frame);
        add(control, BorderLayout.SOUTH);
        add(control, BorderLayout.NORTH);
        add(control, BorderLayout.WEST);
        component = new JTextField(30);
    }
}
