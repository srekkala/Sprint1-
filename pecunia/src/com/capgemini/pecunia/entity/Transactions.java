package com.capgemini.pecunia.entity;


public class Transactions {
public String Account_ID;
public String date;
public double amount;
public Transactions(String account_ID, String date,double amount) {
	super();
	Account_ID = account_ID;
	this.date = date;
	this.amount=amount;
	
}


public Transactions() {
	super();
	// TODO Auto-generated constructor stub
}


@Override
public String toString() {
	return " Account_ID=" + Account_ID + ",date=" +date +  ",amount=" +amount +  "";
}
public String getAccount_ID() {
	return Account_ID;
}
public void setAccount_ID(String account_ID) {
	this.Account_ID = account_ID;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
}

