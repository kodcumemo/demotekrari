package com.tekrar.demotekrari;

import com.tekrar.demotekrari.model.User;
import com.tekrar.demotekrari.model.entity.Product;
import com.tekrar.demotekrari.request.Sales;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DemotekrariApplication {
	public static ArrayList<Product> products = new ArrayList<>();
	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Sales> saless = new ArrayList<>();
 	public static void main(String[] args) {
		SpringApplication.run(DemotekrariApplication.class, args);



	}

}
