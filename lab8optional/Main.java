package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        DataBase database = DataBase.getInstance();

        Connection con = database.conexiune();

        Statement stmt = con.createStatement();
        ArtistController artistcontroller = new ArtistController(database);
        AlbumControlloer albumcontroller = new AlbumControlloer((Connection) database);
        ChartController chart = new ChartController(database);
        Album album1 = new Album();
        Album album2 = new Album();
        Album album3 = new Album();
        Artist artist1 = new Artist();
        Artist artist2 = new Artist();
        Artist artist3 = new Artist();
        album1.randomdata();
        album2.randomdata();
        album3.randomdata();
        artist1.randomdata();
        artist2.randomdata();
        artist3.randomdata();
        chart.create(1, artist1.GetId(), album1.GetName(), artist1.GetNume());
        chart.create(2, artist2.GetId(), album2.GetName(), artist2.GetNume());
        chart.create(3, artist3.GetId(), album3.GetName(), artist3.GetNume());
        chart.showChart();
    }
}
