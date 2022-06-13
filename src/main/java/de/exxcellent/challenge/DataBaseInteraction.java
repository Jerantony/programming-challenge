package de.exxcellent.challenge;

import java.sql.*;
import java.util.List;

public class DataBaseInteraction {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/exxcellent_coding_challenge";
    private static final String USER = "Jeremy";
    private static final String PASS = "Kybnul29000#";

    private Connection con;
    private Statement stm;
    private ResultSet rs;

    public DataBaseInteraction() {
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            stm = con.createStatement();
            rs = null;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTable(String name, String[] attributes){
        //ToDo
    }

    public void insertValues(String table, String[] attributes, List<String[]> values){
        //ToDo
    }

    public String argMinAbsDiff(String table, String arg, String attribute1, String attribute2){
        //ToDo
        return null;
    }

}
