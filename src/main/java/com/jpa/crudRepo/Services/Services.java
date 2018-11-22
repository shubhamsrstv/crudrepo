package com.jpa.crudRepo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.crudRepo.beans.Beans;
import com.jpa.crudRepo.dao.Dao;

@Service
public class Services 
{
	@Autowired
	Dao dao;
	
	Beans beans = new Beans();

	@SuppressWarnings("resource")
	public void deleteAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter deleting details : ");
		System.out.println("Account Number : ");
		beans.setAccountNumber(sc.nextLong());
		Beans result = null;
		try {
		result = dao.findById(beans.getAccountNumber()).get();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		if(result!=null)
		{
		dao.deleteById(beans.getAccountNumber());
		}
		else
		{
			System.out.println("Account number not valid!");
		}
	}

	@SuppressWarnings("resource")
	public void transferAmount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter transfer details : ");
		System.out.println("First Account Number : ");
		Long account1 = sc.nextLong();
		System.out.println("Second Account Number : ");
		Long account2 = sc.nextLong();
		System.out.println("Amount : ");
		float amount = sc.nextFloat();
		Beans result = null;
		Beans result2 = null;
		try {
		result = dao.findById(account1).get();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		if(result!=null)
		{
			try {
			result2 = dao.findById(account2).get();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			if(result2!=null) {
		if(amount<=0)
		{
			System.out.println("Wrong amount");
		}
		else {
			if(amount>result.getAmount())
			{
				System.out.println("Transaction not possible");
			}
			else {
				result.setAmount(result.getAmount()-amount);
				result2.setAmount(result2.getAmount()+amount);
				List<Beans> results = new ArrayList<Beans>();
				results.add(result);
				results.add(result2);
				/*dao.save(result);
				dao.save(result2);*/
				dao.saveAll(results);
			}
			
		}}
			else
			{
				System.out.println("Second Account number not valid!");
			}
		}
		else
		{
			System.out.println("First Account number not valid!");
		}
	}

	@SuppressWarnings("resource")
	public void withdrawAmount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter withdraw details : ");
		System.out.println("Account Number : ");
		beans.setAccountNumber(sc.nextLong());
		System.out.println("Amount : ");
		float amount = sc.nextFloat();
		Beans result = null;
		try {
		result = dao.findById(beans.getAccountNumber()).get();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		if(result!=null)
		{
		if(amount<=0)
		{
			System.out.println("Wrong amount");
		}
		else {
			if(amount>result.getAmount())
			{
				System.out.println("Transaction not possible");
			}
			else {
				result.setAmount(result.getAmount()-amount);
				
				dao.save(result);
			}
			
		}
		}
		else
		{
			System.out.println("Account number not valid!");
		}
	}

	@SuppressWarnings("resource")
	public void depositAmount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter deposit details : ");
		System.out.println("Account Number : ");
		beans.setAccountNumber(sc.nextLong());
		System.out.println("Amount : ");
		float amount = sc.nextFloat();
		Beans result = null;
		try {
		result = dao.findById(beans.getAccountNumber()).get();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		if(result!=null)
		{
		if(amount<=0)
		{
			System.out.println("Wrong amount");
		}
		else {
			result.setAmount(result.getAmount()+amount);
			dao.save(result);
		}
		}
		else
		{
			System.out.println("Account number not valid!");
		}
	}

	@SuppressWarnings("resource")
	public void createAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer details : ");
		System.out.println("Name : ");
		beans.setName(sc.nextLine());
		System.out.println("Aadhar Card : ");
		beans.setAadharCard(sc.nextLong());
		System.out.println("Mobile number : ");
		beans.setMobile(sc.nextLong());
		Beans result = dao.findByAadhar(beans.getAadharCard());
		if(result==null) {
			System.out.println(beans.toString());
		dao.save(beans);
		}
		else {
			System.out.println("Aadhar card is not unique");
		}
	}

}
