package com.jpa.crudRepo.beans;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "banking")
public class Beans 
{
	@Column(name="account_number")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long account_number;
	private String name;
	private long aadhar_card;
	private long mobile;
	@ColumnDefault("0")
	private float amount;
	
	
	public long getAccountNumber() {
		return account_number;
	}
	public void setAccountNumber(long account_number) {
		this.account_number = account_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAadharCard() {
		return aadhar_card;
	}
	public void setAadharCard(long aadhar_card) {
		this.aadhar_card = aadhar_card;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}	
	public Beans(long aadhar_card,float amount,long mobile,String name) {
		this.aadhar_card=aadhar_card;
		this.amount=amount;
		this.mobile=mobile;
		this.name=name;
	}
	@Override
	public String toString() {
		return "Beans [accountNumber=" + account_number + ", name=" + name + ", aadharCard=" + aadhar_card + ", mobile="
				+ mobile + ", amount=" + amount + "]";
	}
	public Beans() {
		
	}
}