package com.company;
import java.sql.*;
public class DataBase {
    private static DataBase single_instance = null;

        public static DataBase getInstance() {
            if (single_instance == null)
                single_instance = new DataBase();

            return single_instance;
        }

        public static Connection conexiune() throws SQLException {
            Connection con=DriverManager.getConnection("jdbc:sqlite:D:\\dbbrowser\\MusicAlbums.db");
            return con;
        }
}


