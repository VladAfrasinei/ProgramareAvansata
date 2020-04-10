package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public Board board;
    public int nrleft;
    public boolean end;
    public List<Player> players= new ArrayList<Player>();;

    Game(int limit, Board board, Player players){
        this.board=board;
        this.nrleft=limit;
        if(players.length>nrleft){
            Collections.addAll(this.players,players);
        }
        end=false;
    }

    public Game() {

    }

    synchronized public Token extractToken(int index){

        Token aux =this.board.getTokens().get(index);
        this.board.getTokens().remove(index);
        return aux;
    }

    public int getNrTokensLeft(){
        return this.board.getNumberOfTokens();
    }
    public void startGame(){
        board= new Board(1000,1200);

        players.add(new Player("Vlad1", board));
        players.add(new Player("Vlad2",board));

        Runnable firstPlayer= (Runnable) players.get(1);
        Runnable secondPlayer= (Runnable) players.get(2);
        //list of all the players
        System.out.println("List of all players");
        Thread Player= new Thread((Runnable) players.get(0));
        //threads created fr each player
        new Thread(secondPlayer).start();
    }

}