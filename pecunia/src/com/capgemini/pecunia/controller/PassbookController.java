package com.capgemini.pecunia.controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.capgemini.pecunia.dao.IncorrectAccountNoException;
import com.capgemini.pecunia.entity.Transactions;
import com.capgemini.pecunia.service.PassbookMaintenanceServiceImpl;

public class PassbookController {
	static String accountID;
	static PassbookMaintenanceServiceImpl service=new PassbookMaintenanceServiceImpl ();
	public static void main(String[] args) throws Exception {
		while(true) {
		System.out.println("1.Passbook Update");
		System.out.println("2.Account Summary");
		System.out.println("enter your choice");
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		switch(choice) 
		{
		case 1:
			try {
			System.out.println("enter accountID:");
			String accountID=scan.next();
			List<Transactions> l=service.updatePassbook(accountID);
			int count=0;
			Iterator<Transactions> iterator = l.iterator();
			if(iterator.hasNext()) {
				System.out.println("AccountID\t\tDate\t\tAmount");
				do{
                  Transactions transactionsList=iterator.next();
					System.out.println(transactionsList.getAccount_ID()+"\t    "+transactionsList.getDate()+"\t\t"+transactionsList.getAmount());
					count++;
				}
				while(iterator.hasNext());
				System.out.println("Total number of transactions are:" +count);
				}
				else
				System.out.println("No Records found");
			}
			
			catch (IncorrectAccountNoException e) {
                System.out.println("Account Id is incorrect");
            } 
			break;
			
		case 2:
			System.out.println("enter account id:");
			String accountID=scan.next();
			System.out.println("enter start date(dd-mmm-yyyy)");
			String startDate = scan.next();
			while (!service.dateValidate(startDate)) {
				System.out.println("enter valid entry date(dd-mmm-yyyy)");
				startDate = scan.next();
			}
			System.out.println("enter last date(dd-mmm-yyyy)");
			String lastDate = scan.next();
			while (!service.dateValidate(lastDate)) {
				System.out.println("enter valid exit date(dd-mmm-yyyy)");
				lastDate = scan.next();
			}
			//COMPARING DATES
			while (service.dateCompare(startDate, lastDate)) {
				System.out.println("enter valid start date(dd-mmm-yyyy)");
				startDate = scan.next();
				while (!service.dateValidate(startDate)) {
					System.out.println("enter valid last date(dd-mmm-yyyy)");
					startDate = scan.next();
				}
				System.out.println("enter last date(dd-mmm-yyyy)");
				lastDate = scan.next();
				while (!service.dateValidate(lastDate)) {
					System.out.println("enter valid last date(dd-mmm-yyyy)");
					lastDate = scan.next();
				}
			}
				
			List<Transactions> al = service.accountSummary(accountID, startDate, lastDate);
			Iterator<Transactions> it = al.iterator();
			if(it.hasNext()) {
				System.out.println("AccountID\t\tDate\t\tAmount");
				do{
                  Transactions transactionsList=it.next();
					System.out.println(transactionsList.getAccount_ID()+"\t    "+transactionsList.getDate()+"\t\t"+transactionsList.getAmount());
				}
				while(it.hasNext());
				}
				else
				System.out.println("No Records found");
			break;
		default:
			System.out.println("Thank you!");
			
}
		
}
	}
	}
