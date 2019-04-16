package com.app.miaaw;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.miaaw.WebpageEnhancer.SoupChef;

@SpringBootApplication
public class MiaawApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiaawApplication.class, args);
		
		try {
			SoupChef.getSoup("https://stackoverflow.com/questions/2835505");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
