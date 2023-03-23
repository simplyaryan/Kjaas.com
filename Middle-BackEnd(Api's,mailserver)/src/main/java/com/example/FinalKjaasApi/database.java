package com.example.FinalKjaasApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    private static Connection connection = null;
    private static boolean connect = false;
    private static Statement stmt = null;

    private static boolean connect() {

        boolean temp = false;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://10.0.0.221:5432/postgres", "root", "root");
            connection.setAutoCommit(false);
            if (connection != null) {
                temp = true;

            } else {
                temp = false;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        connect = true;
        return temp;
    }

    private static void disconnect() throws SQLException {
        connection.close();
        connect = false;
    }



    public static boolean commit(String name, long phonenumber , String email , String description , String date , String time) throws SQLException {

        boolean done = false;
        database.connect();
        if (connect == true) {
            stmt = connection.createStatement();
            String sql = "INSERT INTO userdata (NAME,PHONENUMBER,EMAIL,DESCRIPTION,DATE,TIME)" + "VALUES('"+ name
                    + "','" + phonenumber + "','" + email + "','" + description + "','" + date + "','" + time + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
            database.disconnect();
            done = true;
            
        } else {
            done = false;
        }
        return done;
    }
    public static boolean delete() throws SQLException {
        connect();
        if (connect == true) {
            stmt = connection.createStatement();
            String sql = "DELETE FROM userdata";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
            database.disconnect();
            return true;
        } else {
            return false;
        }
    }

}