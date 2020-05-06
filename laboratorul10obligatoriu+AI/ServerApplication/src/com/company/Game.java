package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin =
                new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board();
        Player player1=new Player();
        Player player2=new Player();
        player1.setValoare(1);
        player1.setNume("Player1");
        player2.setValoare(2);
        player2.setNume("Player2");
        int ok=0;
        int nr=0;//va reprezinta fiecare player, daca %2 e 0 este player-ul 2 daca nu e primul
        board.initBoard();
        while(ok==0)
        {
            nr++;
            int lin,col;
            if(nr%2==1){
                player1.player();
                lin=player1.getLinie();
                col=player2.getColoana();
                board.moveonBoard(lin,col,1,ok);
                if(ok==1)
                    System.out.println("Player 1 won");
                else
                    if(ok==3)
                        System.out.println("It s a tie");

            }
            else{
                player2.player();
                col=player2.getColoana();
                lin=player2.getLinie();
                board.moveonBoard(lin,col,2,ok);
                if(ok==1)
                    System.out.println("Player 2 won");
                else
                if(ok==3)
                    System.out.println("It s a tie");
            }
        }
    }
}
