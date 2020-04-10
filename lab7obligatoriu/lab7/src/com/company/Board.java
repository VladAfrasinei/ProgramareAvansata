package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    private List<Token> tokens;

    public Board(Integer nrtoken, Integer vmax) {
        tokens = new ArrayList<>();
        for (int i = 0; i < nrtoken; i++) {
            tokens.add(new Token(vmax));
        }
    }

    public synchronized Token play(Player player) {
        Token tokenAles = null;
        try {
            this.notifyAll();
            this.wait();
            if (tokens.size() == 0) {
                this.notifyAll();
                return null;
            }
            System.out.println("Randul jucatorului " + player.getName());
            printTokens();
            tokenAles =player.tokenAles(this);
            System.out.println("Randul jucatorului " + player.getName() + " e gata\n");
        } catch (Exception ignored) {
            System.out.println("Fail");
        }
        return tokenAles;
    }

    public List<Token> getTokens() {
        return tokens;
    }
    public int getNumberOfTokens(){
        return this.tokens.size();
    }
    public void printTokens() {
        for (int i = 0; i < tokens.size(); i++) {
            System.out.println(i + 1 + " : " + tokens.get(i));
        }
    }
}