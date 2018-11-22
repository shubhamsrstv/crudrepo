package com.jpa.crudRepo;

import java.util.Scanner;

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
	}

	@SuppressWarnings("resource")
	@Override
	public void run(String... args) throws Exception
	{
		String answer;
		do {
		System.out.println("Enter the choice : ");
		System.out.println("1. To create account.");
		System.out.println("2. To deposit amount.");
		System.out.println("3. To withdraw amount.");
		System.out.println("4. To transfer amount between accounts.");
		System.out.println("5. To delete account.");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:{
			createAccount();
			break;
		}
		case 2:{
			depositAmount();
			break;
		}
		case 3:{
			withdrawAmount();
			break;
		}
		case 4:{
			transferAmount();
			break;
		}
		case 5:{
			deleteAccount();
			break;
		}
		default:{
			System.out.println("Entered wrong number.");
		}
		}
		System.out.println("Do you want to continue?");
		answer = sc.next();
		}
		while(answer.equalsIgnoreCase("Y"));
	}

	private void deleteAccount() {
		services.deleteAccount();	
	}

	private void transferAmount() {
		services.transferAmount();
	}

	private void withdrawAmount() {
		services.withdrawAmount();
	}

	private void depositAmount() {
		services.depositAmount();
	}

	private void createAccount() {
		services.createAccount();	
	}
}
