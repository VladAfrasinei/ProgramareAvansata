package com.company;

public class Player{
    public String nume;
    public int valoare;
    public int linie;
    public int coloana;

    public int getLinie() {
        return linie;
    }

    public int getColoana() {
        return coloana;
    }

    public void setColoana(int coloana) {
        this.coloana = coloana;
    }

    public void setLinie(int linie) {
        this.linie = linie;
    }

    public int getValoare() {
        return valoare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setValoare(int valoare) {
        this.valoare = valoare;
    }
    public void player(){
        ClientThread client1=new ClientThread();
        client1.run();
        setLinie(client1.getLinie());
        setColoana(client1.getColoana());
    }
}