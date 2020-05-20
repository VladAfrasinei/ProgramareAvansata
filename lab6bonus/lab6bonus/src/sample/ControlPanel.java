package com.company;
import javax.imageio.ImageIO;
import javax . swing .*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.FileInputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    JButton saveBtn = new JButton("Save");
    JButton loadBtn=new JButton("Load");
    JButton resetBtn=new JButton("Reset");
    JButton exitBtn=new JButton("Exit");
    //create all buttons (Load, Reset, Exit)
    public ControlPanel() {
         init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }
    private void save(ActionEvent e) {

        try {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                ImageIO.write(frame.canvas.image, "PNG", new File(selectedFile.getAbsolutePath()));
            }
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void load(ActionEvent e)
    {
        try {
            BufferedImage image;
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                image=ImageIO.read(new File(selectedFile.getAbsolutePath()));
                frame.canvas.graphics.drawImage(image, 0, 0, this);
            }
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e)
    {
        frame.canvas.clear();
    }
    private void exit(ActionEvent e)
    {
        System . exit (0) ;
    }
}
