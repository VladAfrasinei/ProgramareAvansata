package com.company;
public class Chart {
    int poz;
    int idalbum;
    String albumnume;
    String artistnume;

    public Chart() {}

    public Chart(int poz1, int idalbum1, String albumnume1, String artistnume1) {
        this.poz= poz;
        this.idalbum= idalbum1;
        this.albumnume = albumnume1;
        this.artistnume = artistnume1;
    }
    public int GetPoz() {
        return poz;
    }

    public void SetPoz(int poz1) {
        this.poz = poz1;
    }

    public int GetIdAlbum() {
        return idalbum;
    }

    public void SetIdAlbum(int idalbum1) {
        this.idalbum = idalbum1;
    }

    public String GetAlbumNume() {
        return albumnume;
    }

    public void SetAlbumNume(String albumnume1) {
        this.albumnume = albumnume1;
    }

    public String GetArtistNume() {
        return artistnume;
    }

    public void SetArtistNume(String artistnume1) {
        this.artistnume = artistnume1;
    }

}