package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class ChartController {
    Connection conn;

     ChartController(DataBase db) throws SQLException {
        this.conn = db.conexiune();
    }

    //in functia creare vom insera in tabel
    public void create(int poz, int idalbum, String albumnume, String artistnume) {

        try {
            String query = "insert into chart values( ?, ?, ?, ?)";
            // prepares query
            PreparedStatement stmt = conn.prepareStatement(query);
            // sets an argument in place of ? in the query String
            stmt.setInt(1, poz);
            stmt.setInt(2, idalbum);
            stmt.setString(3, albumnume);
            stmt.setString(4, artistnume);
            // executes query
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //aici vom gasi artistul dupa stringul nume
    public void FindByArtist(String artiststmt){

        try {
            String query = "select * from chart where idartist= ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, artiststmt);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // returns a list of all artists in chart table
    public void showChart() {
        try {
            String query = "SELECT * FROM charts where idartist = " + "'" + " order by poz";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String albumnume1 = rs.getString("albumnume");
                int poz1 = rs.getInt("poz");
                System.out.println("Album Name: " + albumnume1);
                System.out.println("Rank: " + poz1);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

}