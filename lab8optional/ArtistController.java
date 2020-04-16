package com.company;

import java.sql.*;
import java.sql.ResultSet;

public class ArtistController{
    Connection conn;

    public ArtistController(DataBase db) throws SQLException {
        conn = db.conexiune();
    }

    public ArtistController() {

    }

    // inserts an artist into artists table
    public void create(String nume, String tara,int id) {
        try {
            String query = "insert into artists values(?, ?, ?)";
            // prepares query
            PreparedStatement stmt = conn.prepareStatement(query);
            // sets an argument in place of ? from the query String
            stmt.setString(1, nume);
            stmt.setString(2, tara);
            stmt.setString(3, String.valueOf(id));

            // executes query
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // returns the id of the last inserted artist
    public int GetLastID(){
        int returnID = 1;
        try{
            String query = "select max(id) from artists";
            PreparedStatement prep = conn.prepareStatement(query);
            ResultSet rs = prep.executeQuery();
            rs.next();
            returnID = rs.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return returnID;
    }

    // finds an album by the artist's name
    public Artist FindByName(String nume){
        Artist artist = new Artist();
        try {
            String query = "select * from artists where name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nume);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                artist = new Artist(rs.getInt(1),rs.getString(2),rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artist;
    }

}
