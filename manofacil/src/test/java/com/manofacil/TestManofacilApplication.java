package com.manofacil;

import org.springframework.boot.SpringApplication;

public class TestManofacilApplication {

	public static void main(String[] args) {
		SpringApplication.from(ManofacilApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
