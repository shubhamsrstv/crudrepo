package com.jpa.crudRepo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jpa.crudRepo.Services.Services;
import com.jpa.crudRepo.beans.Beans;
import com.jpa.crudRepo.dao.Dao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	Dao dao;
	
	@Autowired
	Services services;
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	@ResponseBody
	private Beans createAccount(@RequestBody Beans bean) {
		return services.createAccount(bean);
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.POST)
	@ResponseBody
	private Beans depositMoney(@RequestParam long accountNumber, float amount) {
		return services.depositAmount(accountNumber, amount);
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	@ResponseBody
	private Beans withdrawMoney(@RequestParam long accountNumber, float amount) {
		return services.withdrawAmount(accountNumber, amount);
	}
	
	@RequestMapping(value="/transfer", method=RequestMethod.POST)
	@ResponseBody
	private List<Beans> transferMoney(@RequestParam long account1,long account2, float amount) {
		return services.transferAmount(account1, account2, amount);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	private void delete(@RequestParam long accountNumber) {
		services.deleteAccount(accountNumber);
	}
	
	@RequestMapping(value="/deleteAll", method=RequestMethod.POST)
	@ResponseBody
	private void deleteAll() {
		services.deleteAllAccount();
	}
	
	@RequestMapping(value="/details", method=RequestMethod.POST)
	@ResponseBody
	private Beans details(@RequestParam long accountNumber) {
		return services.details(accountNumber);
	}
}
