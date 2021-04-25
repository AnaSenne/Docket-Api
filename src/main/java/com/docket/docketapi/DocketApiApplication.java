package com.docket.docketapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.docket.docketapi.model.Cartorio;

@SpringBootApplication
public class DocketApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocketApiApplication.class, args);
		
	}

}
