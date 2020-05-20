package com.company;
import sample.ControlBonus;

import javax . swing .*;
import java.awt.*;

public class MainFrame extends JFrame{
    ControlBonus controlBonus;
    com.company.ControlPanel controlPanel;
    Canvas canvas;
    public MainFrame() {
        super("My Drawing Application");
        init();
    }
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        controlPanel=new com.company.ControlPanel();
        controlBonus=new ControlBonus();
        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        add(controlPanel,BorderLayout.SOUTH);
        add(controlBonus,BorderLayout.NORTH);
        //invoke the layout manager
        pack();
    }
}
