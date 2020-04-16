package com.company;

import java.sql.*;


public class AlbumControlloer {
    Connection conn;

    public AlbumControlloer(Connection con) {
    }

    public AlbumControlloer() {

    }

    public void AlbumController(DataBase db) throws SQLException {
        conn = db.conexiune();
    }

    public void create(String name, int artistID, int releaseYear, int id) {

        try {
            String query = "insert into albums values( ?, ?, ?, ?)";
            // prepares query
            PreparedStatement stmt = conn.prepareStatement(query);
            // sets an argument in place of ? from the query String
            stmt.setString(1, name);
            stmt.setInt(2, artistID);
            stmt.setInt(3, releaseYear);
            stmt.setInt(4, id);
            // executes query
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int GetLastID(){
        int returnID = 1;
        try{
            String query = "select max(id) from albums";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                returnID = rs.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return returnID;
    }

    public Album findByArtist(int idartist1){
        Album album = new Album();
        try {
            String query = "select * from albums where idartist = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idartist1);
            ResultSet rs = stmt.executeQuery();
            while( rs.next() )
                album = new Album(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }
}