package com.example.FinalKjaasApi;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/newappointment")
public class api {
    @Autowired
    private EmailSender service;
    @CrossOrigin
    @PostMapping
    public person createAppointment(@RequestBody person userRequest) throws SQLException {
            person newperson = userRequest;
            newperson.databasecommit();
            service.sendEmail(newperson.getEmail(),"New appointment ", newperson.getDescription());
           // database.delete();
            return newperson;   
    }
    
}

