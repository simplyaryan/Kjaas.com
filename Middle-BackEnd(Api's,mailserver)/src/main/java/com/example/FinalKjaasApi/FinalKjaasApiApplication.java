package com.example.FinalKjaasApi;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalKjaasApiApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(FinalKjaasApiApplication.class, args);
		database.delete();
	}

}
