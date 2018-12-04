package com.jpa.crudRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.crudRepo.Services.Services;
import com.jpa.crudRepo.beans.Beans;

@SpringBootApplication
public class CrudRepoApplication implements CommandLineRunner
{
	@Autowired
	Services services;
	Beans beans = new Beans();
	

	public static void main(String[] args) 
	{
		SpringApplication.run(CrudRepoApplication.class, args);
		System.out.println("This is the main method.");
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.out.println("This is a demo program.");
	}
}
