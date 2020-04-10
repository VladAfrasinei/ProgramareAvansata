package com.company;

import java.sql.*;

public class AlbumControlloer {
    private final Connection con;

    public AlbumControlloer(Connection con) {
        this.con = con;
    }

    public void InsertAlbum(String name, Integer artistid, Integer ReleaseYear) throws SQLException {
        String query = "insert into albums(id,name,artist_id,release_year) values(1,'" + name + "'," + artistid + "," + ReleaseYear + ")";
        PreparedStatement a=con.prepareStatement(query);
        ResultSet rs=a.executeQuery();
        rs.next();
    }
    public void FindByArtist(int artistid) throws SQLException {
        ResultSet rs;
        String sql = "select * from albums where artist_id=" + artistid;
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
                    + rs.getString(4));
        }
    }
}
