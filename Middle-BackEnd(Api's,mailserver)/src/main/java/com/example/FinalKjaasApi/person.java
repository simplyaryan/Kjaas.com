package com.example.FinalKjaasApi;

import java.sql.SQLException;

public class person {
    private String name;
    private long phonenumber;
    private String email;
    private String description;
    private String date;
    private String time;
    public person(String name, long phonenumber, String email, String description, String date, String time) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.description = description;
        this.date = date;
        this.time = time;
    }
    public String getEmail(){
        return email;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public String getDescription(){
        return "From KjaasMailling Service"+description;
    }
    public void databasecommit() throws SQLException{
        database.commit(name, phonenumber, email, description, date, time);
    }
}
