package com.jpa.crudRepo.Services;

import java.util.ArrayList;
import java.util.List;

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

	public void deleteAccount(long accountNumber) {
		Beans result = null;
		try {
		result = dao.findById(accountNumber).get();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		if(result!=null)
		{
		dao.deleteById(accountNumber);
		}
		else
		{
			System.out.println("Account number not valid!");
		}
	}

	public List<Beans> transferAmount(long account1,long account2, float amount) {
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
				return results;
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
		return null;
	}
	
	public Beans withdrawAmount(long accountNumber, float amount) {
		Beans result = null;
		try {
		result = dao.findById(accountNumber).get();
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
			result.setAmount(result.getAmount()-amount);
			dao.save(result);
			return result;
		}
		}
		else
		{
			System.out.println("Account number not valid!");
		}
		return null;
	}


	public Beans depositAmount(long accountNumber, float amount) {
		Beans result = null;
		try {
		result = dao.findById(accountNumber).get();
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
			return result;
		}
		}
		else
		{
			System.out.println("Account number not valid!");
		}
		return null;
	}
	

	public Beans createAccount(Beans bean) {
		Beans beans = new Beans();

		beans.setAadharCard(bean.getAadharCard());
		beans.setMobile(bean.getMobile());
		beans.setName(bean.getName());
		Beans result = dao.findByAadhar(beans.getAadharCard());
		if(result==null) {
		dao.save(beans);
		return beans;
		}
		else {
			System.out.println("Aadhar card is not unique");
		}
		return null;
	}
	

	public void deleteAllAccount() {
		dao.deleteAll();
		System.out.println("All entity deleted.");
	}

	public Beans details(long accountNumber) {
		Beans result = null;
		try {
			result = dao.findById(accountNumber).get();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			if(result!=null)
			{
				return result;
			}
			else {
				System.out.println("No matching account found.");
			}
		return null;
		
	}
}
