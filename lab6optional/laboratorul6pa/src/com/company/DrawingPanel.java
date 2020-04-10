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
        String tool=String.valueOf(frame.configPanel.toolCombo.getSelectedItem());
        Color color = Color.BLACK;//create a transparent random Color
        String col=String.valueOf(frame.configPanel.colorCombo.getSelectedItem());
        String forma="Poligon";
        forma=String.valueOf(frame.configPanel.shapeCombo.getSelectedItem());
        if(tool=="Paint") {
            if (!col.equals("Black")) {
                float r, g, b;
                r = randomize.nextFloat();
                g = randomize.nextFloat();
                b = randomize.nextFloat();
                color = new Color(r, g, b);
            }
        }
        else
            color=Color.WHITE;
        graphics.setColor(color);
        if(forma=="Romb")
        graphics.fill((Shape) new RegularPolygon(x, y, radius,4));
            else
                if(forma=="Hexagon")
                    graphics.fill((Shape) new RegularPolygon(x, y, radius,6));
                else
                    if(forma=="Heptagon")
                        graphics.fill((Shape) new RegularPolygon(x, y, radius,7));
                    else
                        if(forma=="Octogon")
                            graphics.fill((Shape) new RegularPolygon(x, y, radius,8));
                            if(forma=="Pentagon")
                                graphics.fill((Shape) new RegularPolygon(x, y, radius,5));
        else
            if(forma=="Cerc")
                graphics.fill((Shape) new NodeShape(x, y,radius));
            else
                if(forma=="Patrat")
                    graphics.fill((Shape) new RegularPolygon(x, x, radius,4));

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