package com.example.bdhotel;

import com.example.bdhotel.models.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BdHotelApplication {
	public static Client  currentUser = null;
	public static void main(String[] args) {

		SpringApplication.run(BdHotelApplication.class, args);
	}

}
