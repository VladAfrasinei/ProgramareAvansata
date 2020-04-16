package com.company;

import java.sql.SQLException;
import java.util.Random;

public class Album {
    int id;
    String nume;
    int idartist;
    int yearrelease;

    public Album() {}

    public Album(int id, String nume, int idartist, int yearrelease) {
        this.id = id;
        this.nume= nume;
        this.idartist = idartist;
        this.yearrelease = yearrelease;
    }

    public int GetId() {
        return id;
    }

    public void SetId(int id) {
        this.id = id;
    }

    public String GetName() {
        return nume;
    }

    public void SetName(String nume) {
        this.nume = nume;
    }

    public int GetIdArtist() {
        return idartist;
    }

    public void SetIdArtist(int idartist) {
        this.idartist = idartist;
    }

    public int GetYearRelease() {
        return yearrelease;
    }

    public void SetYearRelease(int yearrelease) {
        this.yearrelease = yearrelease;
    }
    public void randomdata() throws SQLException {
        AlbumControlloer control=new AlbumControlloer();
        this.id=control.GetLastID()+1;
        String[] NumeAlbume={"Album1","Album2","Album3","Album4","Album5","Album6","Album7","Album8","Album9"};
        Random rnd=new Random(NumeAlbume.length);
        this.nume=NumeAlbume[rnd.nextInt()];
        ArtistController control1=new ArtistController();
        int artistidr=control1.GetLastID();
        Random rnd1=new Random();
        this.idartist=rnd1.nextInt(artistidr)+1;
        Random rnd2=new Random();
        this.yearrelease=1900+rnd2.nextInt(120);
    }
}
