package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player {
    public int length;
    String name;
    Board board;
    List<Token> tokenalese;
    public String getName() {
        return name;
    }
    public Player(String name1,Board board1)
    {
        this.board=board1;
        this.name=name1;
        tokenalese=new ArrayList<>();
    }
    public int alg() {
        tokenalese.sort(new Comparator<Token>() {
            @Override
            public int compare(Token o1, Token o2) {
                return o1.getValoare()-o2.getValoare();
            }

            public int comparare(Token a1, Token a2) {
                return a1.getValoare() - a2.getValoare();
            }
        });
        System.out.println(name +" "+tokenalese);
        int lenghtMax = 2;
        Token token = new Token(1);
        for (int i = 0; i < tokenalese.size() - 1; i++) {
            for (int j = i + 1; j < tokenalese.size(); j++) {
                final int dif = tokenalese.get(j).getValoare() - tokenalese.get(i).getValoare();
                if (dif != 0) {
                    int lenght = 2;
                    token.setValoare(tokenalese.get(j).getValoare() + dif);
                    while (tokenalese.contains(token)) {
                        lenght++;
                        token.setValoare(token.getValoare() + dif);
                    }
                    if (lenght > lenghtMax) {
                        lenghtMax = lenght;
                    }
                }
            }
        }
        length=lenghtMax;
        return lenghtMax;
    }

    public Token tokenAles(Board board) {
        return null;
    }
    protected void endMsg(){
        System.out.println("Punctaj " + name + " " + alg());
    }

}
