package com.example.bdhotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.bdhotel.models"})

public class BdHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(BdHotelApplication.class, args);
	}

}
