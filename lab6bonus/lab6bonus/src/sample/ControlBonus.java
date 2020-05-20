package sample;
import javax.imageio.ImageIO;
import javax . swing .*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;

public class ControlBonus extends JPanel {
    public Canvas canvas;
    public int radius=7;
    JButton addEdge = new JButton("addEdge");
    JButton deleteEdge=new JButton("deleteEdge");
    JButton addNod=new JButton("addNod");
    JButton deleteNod=new JButton("deleteNod");
    int [][]matrice=new int[1000][1000];//aplicatia e de W=800 SI H=600 dar am zis sa bag mai mult ca nu strica:) Aceasta este o matrice de noduri.
    int [][][][]muchii=new int[1000][1000][1000][1000];//Da stiu ca puteam sa fac o lista de liste, doar ca efectiv nu am mai avut rabdarea sa schimb codul, ca trebuia sa scot si prima matrice
    //muchii[x1][y1][x2][y2] inseamna asa ca nodul(x1,y1) are muchie cu nodul(x2,y2).
    int x,y;
    int x1,y1;
    //actiune va avea 4 valori(1 in caz ca dam addedge, 2 in caz ca dam deleteedge, 3 pentru addnode si 4 pentru deletenod
    //x si y va reprezinta coordonatele de la primul nod, si cum o muchie e intre 2 noduri avem x1 si y1 pentru al doilea nod
    public ControlBonus() {
        init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons
        add(addEdge);
        add(deleteEdge);
        add(addNod);
        add(deleteNod);
        //configure listeners for all buttons
        addEdge.addActionListener(this::adaugaremuchie);
        deleteEdge.addActionListener(this::stergeremuchie);
        addNod.addActionListener(this::adaugarenod);
        deleteNod.addActionListener(this::stergerenod);
    }
    private void stergerenod(ActionEvent actionEvent) {
        this.addMouseListener(new MouseAdapter(){

            private int x2,y2;
            @Override
            public void mousePressed(MouseEvent e)
            {
                x2=e.getX();
                y2=e.getY();
                x=x2;
                y=y2;
            }
        });
        //Avand in vedere ca raza are ca marime mai mult de 1 radius, va trebui sa vedem daca exista vreun nod in aproprierea acestor coordonate
        int xf=-1000,yf=-1000,i,j;
        getclosestpoint(x,y,xf,yf,7);
        if(xf>=0&&yf>=0){
            //Odata ce am gasit un nod va trebui sa stergem mai intai toate muchii aferente cu acesta dupa care nodul
            for(i=0;i<1000;i++)
                for(j=0;j<1000;j++)
                    if(muchii[xf][yf][i][j]>0)
                    {
                        muchii[xf][yf][i][j]=0;
                        //Daca exista muchie de la x la y clar exista si invers
                        muchii[i][j][xf][yf]=0;
                        //Vom elimina aceasta muchie.
                        canvas.getGraphicsContext2D().setStroke(Color.WHITE);
                        //Vom colora cu alb peste
                        canvas.getGraphicsContext2D().strokeLine(xf,yf,i,j);
                        //Avand in vedere ca coloreaza si peste nodul curent si el nu trebui sters il punem la loc.
                        canvas.getGraphicsContext2D().setStroke(Color.RED);
                        canvas.getGraphicsContext2D().fillOval(xf,yf,i,j);
                    }
            //Stergem insfarsit nodul
            matrice[xf][yf]=0;
            //coloram peste nod cu alb
            canvas.getGraphicsContext2D().setFill(Color.WHITE);
            canvas.getGraphicsContext2D().fillOval(xf-radius,yf-radius,radius*2,radius*2);
            //realegem culoarea rosie.
            canvas.getGraphicsContext2D().setFill(Color.RED);
        }
    }

    private void adaugarenod(ActionEvent actionEvent) {
        this.addMouseListener(new MouseAdapter(){

            private int x2,y2;
            @Override
            public void mousePressed(MouseEvent e)
            {
                x2=e.getX();
                y2=e.getY();
                x=x2;
                y=y2;
            }
        });
        //Am adaugat o simpla valoare care inseamna ca exista acest nod
        matrice[x][y]=10;
        //Desenam nodul cu rosu
        canvas.getGraphicsContext2D().setFill(Color.RED);
        canvas.getGraphicsContext2D().fillOval(x-radius,y-radius,radius*2,radius*2);

    }

    private void stergeremuchie(ActionEvent actionEvent) {
        //Aici avem nevoie sa preluam 2 noduri.
        //Pentru a sterge o linie va trebui sa alegem cele 2 noduri care sunt capetele muchiei
        this.addMouseListener(new MouseAdapter(){

            private int x2,y2;
            @Override
            public void mousePressed(MouseEvent e)
            {
                x2=e.getX();
                y2=e.getY();
                x=x2;
                y=y2;
            }
        });
        this.addMouseListener(new MouseAdapter(){

            private int x2,y2;
            @Override
            public void mousePressed(MouseEvent e)
            {
                x2=e.getX();
                y2=e.getY();
                x1=x2;
                y1=y2;
            }
        });
        //Vom elimina aceasta muchie.
        canvas.getGraphicsContext2D().setStroke(Color.WHITE);
        //Vom colora cu alb peste
        canvas.getGraphicsContext2D().strokeLine(x,y,x1,y1);
        canvas.getGraphicsContext2D().setStroke(Color.RED);
        //Va trebuie sa redesenam iar cele 2 noduri.
        canvas.getGraphicsContext2D().setFill(Color.RED);
        canvas.getGraphicsContext2D().fillOval(x-radius,y-radius,radius*2,radius*2);
        canvas.getGraphicsContext2D().setFill(Color.RED);
        canvas.getGraphicsContext2D().fillOval(x1-radius,y1-radius,radius*2,radius*2);
        //stergem si din matrice muchia
        muchii[x][y][x1][y1]=0;
        muchii[x1][y1][x][y]=0;
        //Fiind neorientat trebuie sters din ambele.
    }

    private void adaugaremuchie(ActionEvent actionEvent) {
        //Aici avem nevoie sa preluam 2 noduri.
        //Pentru a adauga o linie va trebui sa alegem cele 2 noduri care sunt capetele muchiei
        this.addMouseListener(new MouseAdapter(){

            private int x2,y2;
            @Override
            public void mousePressed(MouseEvent e)
            {
                x2=e.getX();
                y2=e.getY();
                x=x2;
                y=y2;
            }
        });
        this.addMouseListener(new MouseAdapter(){

            private int x2,y2;
            @Override
            public void mousePressed(MouseEvent e)
            {
                x2=e.getX();
                y2=e.getY();
                x1=x2;
                y1=y2;
            }
        });
        //Vom adauga aceasta muchie.
        canvas.getGraphicsContext2D().setStroke(Color.WHITE);
        //Vom colora cu alb peste
        canvas.getGraphicsContext2D().strokeLine(x,y,x1,y1);
        canvas.getGraphicsContext2D().setStroke(Color.RED);
        //Acum va trebui sa le adaugam atat nodurile in cazul in care nu exista cat si muchia in cele 2 matrici
        matrice[x][y]=10;
        matrice[x1][y1]=10;
        //Am adaugat nodurile, urmeaza muchia
        muchii[x][y][x1][y1]=10;
        muchii[x1][y1][x][y]=10;
        //Trebuie adaugata in ambele sensuri fiind un graf neorientat

    }
    double distanta2pct(int x,int y,int x1,int y1)
    {
        return Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
    }
    void getclosestpoint(int x,int y,int x1,int y1,int distanta)
    {
        //x si y reprezinta coordonatele punctului meu;
        //in x1 si y1 vom pune cel mai apropriat punct gasit care exista, aflandu-se la o distanta mai mica decat distanta. Daca nu gasim niciunul in x1 si y1 se va afla o valoare negativa insemna ca nu exista acest punct pt stergere.
        //distanta este distanta maxima acceptata
        int i,j,ok=0;
        for(i=0;i<1000;i++)
            for(j=0;j<1000;j++)
                if(matrice[i][j]>0)
                    if(distanta2pct(x,y,i,j)<=distanta)
                    {
                        x1=i;
                        y1=j;
                        ok=1;
                    }
        if(ok==0)
            x1=y1=-1000;//nu s-a gasit niciun punct
    }
}
