package com.company;
import javax . swing .*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }
    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius =rand.nextInt(100); //generate a random number
        int sides = (int)frame.configPanel.sidesField.getValue(); //get the value from UI (in ConfigPanel)
        Random random = new Random();
        Random randomize=new Random();
        Color color = Color.BLACK;//create a transparent random Color
        String col=String.valueOf(frame.configPanel.colorCombo.getSelectedItem());
        if(!col.equals("Black")){
            float r,g,b;
            r=randomize.nextFloat();
            g=randomize.nextFloat();
            b=randomize.nextFloat();
            color=new Color(r,g,b);
        }
        graphics.setColor(color);
        graphics.fill((Shape) new RegularPolygon(x, y, radius, sides));
    }
    @Override
    public void update(Graphics g)
    {

    } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
    protected void clear() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
        updateUI();
    }
}