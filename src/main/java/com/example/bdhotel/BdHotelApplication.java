package com.example.bdhotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.bdhotel.models"})
@ComponentScan(basePackages = {"com.example.bdhotel.dal"})
public class BdHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(BdHotelApplication.class, args);
	}

}
