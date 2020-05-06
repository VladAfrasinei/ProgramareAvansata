package com.company;

public class Board {
    public int [][]matrice;//acesta va fi board-ul
    public int nr;//aici vom sti cate mutari am facut pana acum, numarul maxim fiind 100*100;
    public int stopgame;//Poate avea 3 valori, 1 in cazul in care castiga player1, 2 in cazul in care castiga player 2 si 3 in caz de egal

    public Board() {
    }

    //De asemenea pe board vom pune 1 ca valoare pentru player-ul 1 si 2 pentru player-ul 2
    public void initBoard(){
        int i,j;
        for(i=0;i<100;i++)
            for(j=0;j<100;j++)
                matrice[i][j]=0;
            nr=0;//inca nu avem nicio mutare facuta
            stopgame=0;//Nu a castigat nimeni si nici tabla nu s-a terminat
    }
    public void printBoard(){
        int i,j;
        for(i=0;i<100;i++)
        {
            for(j=0;j<100;j++)
                System.out.print(matrice[i][j]+" ");
            System.out.println();
        }
    }
    public void moveonBoard(int l,int c,int nrplayer,int winner){
        //Avand in vedere ca player-ul poate vedea board-ul constant si poate alege doar o casuta libera nu este nevoie de validarea miscarii in board
        matrice[l][c]=nrplayer;//nrplayer poate fi 1 sau 2, avand in vedere ca exista doar 2 jucatori deci fix valorile care pot fi adaugate
        nr++;//S-a mai facut o mutare
        if(wingamecoloana(l,c,nrplayer)>=5)//a castigat mergand pe aceeasi linie coloane diferite
            stopgame=nrplayer;
        if(wingamelinie(l,c,nrplayer)>=5)//a castigat mergand pe aceeasi coloana linii diferite
            stopgame=nrplayer;
        if(wingamediagonala1(l,c,nrplayer)>=5)//a castigat mergand pe prima diagonala
            stopgame=nrplayer;
        if(wingamediagonala2(l,c,nrplayer)>=5)//a castigat mergand pe a doua diagonala
            stopgame=nrplayer;
        if(stopgame==0)
        if(nr==100*100)
            stopgame=3;//Nu mai sunt mutari posibile si cum prin aceasta ultima miscare nu a castigat nimeni s-a terminat jocul egal.
        winner=stopgame;
    }
    public int wingamecoloana(int l, int c, int nrplayer){
        //Aici va trebui sa vedem daca player-ul prin aceasta mutare a castigat jocul. Vom verifica pe coloana
        int c1,c2;
        int ct1,ct2;
        int ok;
        //va trebui sa verific in jos pe coloana
        c1=c-1;//Deoare ne ducem in jos;
        ct1=0;//acesta va reprezenta cate elemente gasim in jos pe goloana si inca pe board.
        while(c1>=0&&matrice[l][c1]==nrplayer)
        {
            c1--;
            ct1++;
        }
        c2=c+1;//Mergem in sus pe coloana;
        ct2=0;
        while(c2<100&&matrice[l][c2]==nrplayer){
            c2++;
            ct2++;
        }
        ok=1+ct1+ct2;//vine 1(elementul pus) + cate am gasit in sus+ cate am gasit in jos
        return ok;
    }
    public int wingamelinie(int l,int c,int nrplayer){
        int l1,l2;
        int ct1,ct2;
        int ok;
        l1=l-1;
        ct1=0;
        while(l1>=0&&matrice[l1][c]==nrplayer)
        {
            ct1++;
            l1--;
        }
        l2=l+1;
        ct2=0;
        while(l2<100&&matrice[l2][c]==nrplayer){
            ct2++;
            l2++;
        }
        ok=1+ct1+ct2;
        return ok;
    }
    public int wingamediagonala1(int l,int c,int nrplayer){
        int c1,c2,l1,l2;
        int ct1,ct2;
        int ok;
        l1=l-1;
        c1=c-1;
        ct1=0;
        //in cazul diagonale ,,principale" cand mergem in sus va trebui sa scadem si linia si coloana
        while(l1>=0&&c1>=0&&matrice[l1][c1]==nrplayer)
        {
            l1--;
            c1--;
            ct1++;
        }
        l2=l+1;
        c2=c+1;
        ct2=0;
        //in cazul diagonalei principale cand coboram va trebui sa marim si linia si coloana
        while(l2<100&&c2<100&&matrice[l2][c2]==nrplayer)
        {
            l2++;
            c2++;
            ct2++;
        }
        ok=1+ct1+ct2;//ca la celelalte functii
        return ok;
    }
    public int wingamediagonala2(int l,int c, int nrplayer){
        int c1,c2,l1,l2;
        int ct1,ct2;
        int ok;
        l1=l-1;
        c1=c+1;
        ct1=0;
        //in cazul diagonale ,,secundare" cand urcam creste coloana si scade linia
        while(l1>=0&&c1<100&&matrice[l1][c1]==nrplayer){
            l1--;
            c1++;
            ct1++;
        }
        l2=l+1;
        c2=c-1;
        ct2=0;
        //in cazul diagonalei ,,secundare" cand mergem in jos creste linia si scade coloana
        while(l2<100&&c2>=0&&matrice[l2][c2]==nrplayer)
        {
            l2++;
            c2--;
            ct2++;
        }
        ok=1+ct1+ct2;//ca la celelalte functii
        return ok;
    }
    public void AiForComputer(int lmax,int cmax,int vmax){
        int i,j;
        int l,c,maxi=0;
        //Pentur a face o strategie destul de ok a calculatorului va trebui sa
        //Avand in vedere ca suntem computer va avea instant valoarea 2 deci va trebui sa cautam pozitia unde sa o punem astfel incat sa avem cele mai multe valori de 2.
        for(i=0;i<100;i++)
            for(j=0;j<100;j++)
            {
                int nr;
                nr=wingamelinie(i,j,2);
                if(nr>maxi)
                {
                    maxi=nr;
                    lmax=i;
                    cmax=j;
                }
                nr=wingamecoloana(i,j,2);
                if(nr>maxi)
                {
                    maxi=nr;
                    lmax=i;
                    cmax=j;
                }
                nr=wingamediagonala1(i,j,2);
                if(nr>maxi)
                {
                    maxi=nr;
                    lmax=i;
                    cmax=j;
                }
                nr=wingamediagonala2(i,j,2);
                if(nr>maxi)
                {
                    maxi=nr;
                    lmax=i;
                    cmax=j;
                }
            }
        vmax=maxi;
    }
    public void moveonBoardvscomputer(int l,int c,int nrplayer,int winner){
        //Avand in vedere ca player-ul poate vedea board-ul constant si poate alege doar o casuta libera nu este nevoie de validarea miscarii in board
        matrice[l][c]=nrplayer;//nrplayer poate fi 1 sau 2, avand in vedere ca exista doar 2 jucatori deci fix valorile care pot fi adaugate
        nr++;//S-a mai facut o mutare
        int lin = 0,col = 0,vm = 0;
        if(nrplayer==2){
            AiForComputer(lin,col,vm);
            l=lin;
            c=col;
        }
        if(wingamecoloana(l,c,nrplayer)>=5)//a castigat mergand pe aceeasi linie coloane diferite
            stopgame=nrplayer;
        if(wingamelinie(l,c,nrplayer)>=5)//a castigat mergand pe aceeasi coloana linii diferite
            stopgame=nrplayer;
        if(wingamediagonala1(l,c,nrplayer)>=5)//a castigat mergand pe prima diagonala
            stopgame=nrplayer;
        if(wingamediagonala2(l,c,nrplayer)>=5)//a castigat mergand pe a doua diagonala
            stopgame=nrplayer;
        if(stopgame==0)
            if(nr==100*100)
                stopgame=3;//Nu mai sunt mutari posibile si cum prin aceasta ultima miscare nu a castigat nimeni s-a terminat jocul egal.
        winner=stopgame;
    }
}
