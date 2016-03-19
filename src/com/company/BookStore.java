package com.company;

import java.sql.*;

/**
 * Created by moneg on 13.03.2016.
 */
public class BookStore {
    private Connection con;
    public BookStore() throws SQLException {
        String url = "jdbc:mysql://localhost/Task_3";
        String name = "user";
        String password = "user";

        Connection con = DriverManager.getConnection(url,name,password);
        System.out.println("Connected");
        System.out.println("Table of sluzg");
        Statement st = con.createStatement();
        String query = "select * from S";
        ResultSet rs = st.executeQuery(query);
        printResults(rs);

        con.close();
        System.out.println("Disconnected");
    }
    private static void printResults(ResultSet rs) throws SQLException {
        String SName, City;
        int SNum;
        double Comm;
        while(rs.next())
        {
            SName = rs.getString("SName");
            City = rs.getString("City");
            Comm = rs.getDouble("Comm");
            SNum = rs.getInt("SNum");
            System.out.println("******************************************");

            System.out.println("SNum: " + SNum);
            System.out.println("SName: " + SName);
            System.out.println("City: " + City);
            System.out.println("Comm: " + Comm);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loading success!");
        BookStore bookStore = new BookStore();
    }

}
