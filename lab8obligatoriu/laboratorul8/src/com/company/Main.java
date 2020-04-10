package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        DataBase database = DataBase.getInstance();

        Connection con = database.conexiune();

        Statement stmt = con.createStatement();
        ArtistController artistcontroller = new ArtistController(con);
        AlbumControlloer albumcontroller = new AlbumControlloer(con);
        artistcontroller.InsertArtist("aida","anglia");
        artistcontroller.FindByName("aida");
        albumcontroller.InsertAlbum("an",7,2020);
        albumcontroller.FindByArtist(7);
    }
}
