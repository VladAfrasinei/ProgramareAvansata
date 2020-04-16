package com.company;

import java.util.Random;

public class Artist {
    int id;
    String nume;
    String tara;

    public Artist() {}

    public Artist(int id, String nume , String tara) {
        this.id = id;
        this.nume = nume;
        this.tara = tara;
    }

    public int GetId() {
        return id;
    }

    public void SetId(int id) {
        this.id = id;
    }

    public String GetNume () {
        return nume ;
    }

    public void SetNume(String nume) {
        this.nume  = nume ;
    }

    public String GetTara() {
        return tara;
    }

    public void SetTara(String country) {
        this.tara = tara;
    }
    public void randomdata()
    {
        ArtistController control=new ArtistController();
        this.id= control.GetLastID() + 1;
        String[] numes={"Nume1","Nume2","Nume3","Nume4","Nume5","Nume6","Nume7","Nume8","Nume9"};
        Random rnd=new Random(numes.length);
        this.nume=numes[rnd.nextInt()];
        String[] taris={"Tara1","Tara2","Tara3","Tara4","Tara5","Tara6","Tara7","Tara8","Tara9"};
        Random rnd1=new Random(taris.length);
        this.tara=taris[rnd.nextInt()];
    }
}
