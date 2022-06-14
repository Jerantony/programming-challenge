package de.exxcellent.challenge;

import java.sql.*;
import java.util.ArrayList;
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

    public boolean containsTable(String table){
        try {
            rs = stm.executeQuery(String.format("show tables like '%s';", table));
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public void insertValues(String table, String[] attributes, List<String[]> valuesList){
        String query;
        try {
        for (String[] values: valuesList) {
            query = String.format("insert into %s (%s) values (%s);", table, String.join(",", attributes),
                    String.join(",", values));
            stm.executeUpdate(query);
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<String[]> readTable(String table){
        return readTable(table, new String[]{"*"});
    }

    public List<String[]> readTable(String table, String[] attributes){
        List<String[]> output = new ArrayList<>();
        String query;
        if (attributes.length == 1 && attributes[0].equals("*")){
            query = String.format("select * from %s;", table);
        } else {
            query = String.format("select (%s) from %s;", String.join(",", attributes), table);
        }

        try {
            rs = stm.executeQuery(query);
            ResultSetMetaData metaData  = rs.getMetaData();
            String[] row;
            while(rs.next()){
                row = new String[metaData.getColumnCount()];
                for(int i=0; i < metaData.getColumnCount(); i++){
                    row[i] = rs.getString(i+1);  // mysql indexing start from 1
                }
                output.add(row);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

    public void clearTable(String table){
        String query = String.format("delete from %s;", table);
        try {
            stm.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    / returns the attribute arg of the smallest entry with respect to the absolute difference between the attributes
    / attribute1 and attribute2
     */
    public String argMinAbsDiff(String table, String arg, String attribute1, String attribute2){
        String query = String.format("select %s from %s order by abs(%s-%s) asc;", arg, table, attribute1, attribute2);
        try {
            rs = stm.executeQuery(query);
            if (rs.next())
                return rs.getString(1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
