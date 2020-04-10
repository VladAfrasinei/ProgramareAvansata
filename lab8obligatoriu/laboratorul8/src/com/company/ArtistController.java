package com.company;

import java.sql.*;

public class ArtistController {
    private final Connection con;

    public ArtistController(Connection con) {
        this.con = con;
    }
    public void InsertArtist(String name, String country) throws SQLException {
        String query = "insert into artists(id,name,country) values(1,'" + name + "','" + country + "')";
        Statement stmt = con.createStatement();
        stmt.execute(query);
        PreparedStatement a=con.prepareStatement(query);
        ResultSet rs=a.executeQuery();
        rs.next();
        stmt.close();
    }
    public void FindByName(String name) throws SQLException {
        ResultSet rs;
        String query = "select * from artists where name='" + name + "'";
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
        stmt.close();
    }
}
