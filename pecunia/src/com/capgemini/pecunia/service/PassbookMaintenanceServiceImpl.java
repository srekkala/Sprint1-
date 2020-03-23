package com.capgemini.pecunia.service;
import java.text.DateFormatSymbols;
import java.util.List;
import com.capgemini.pecunia.dao.PassbookMaintenanceDaoImpl;
import com.capgemini.pecunia.entity.Transactions;

public class PassbookMaintenanceServiceImpl implements PassbookMaintenanceService {
	PassbookMaintenanceDaoImpl dao=new PassbookMaintenanceDaoImpl();

	
	 public List<Transactions> updatePassbook(String accountID) {
		return  dao.updatePassbook(accountID);
	}
	 public List<Transactions> accountSummary(String accountID,String startDate,String lastDate) throws Exception{
		 return dao.accountSummary(accountID,startDate,lastDate);
	 }
	 
	 public boolean dateValidate(String startDate) {
			int count1 = 0, count2 = 0, count3 = 0;
			boolean b = false;
			startDate.replace('/', '-');
			if (startDate.contains("-") && (!(startDate.indexOf("-")==startDate.lastIndexOf("-")))) {
				String sub1 = startDate.substring(startDate.indexOf('-') + 1, startDate.lastIndexOf('-'));//GETTING MONTH FROM STRING
				
				String month;
				// VALIDATING DATE
				if (startDate.substring(0, startDate.indexOf("-")).compareTo("31") <= 0)
				{
					count1 = 1;
				}
				// VALIDATING DATE
				if (startDate.substring(0, startDate.indexOf("-")).length() <= 2) {
					count1++;
				}
				// VALIDATING MONTH
				for (int i = 1; i <= 12; i++) {
					month = new DateFormatSymbols().getMonths()[i - 1];
					if (month.substring(0, 3).equalsIgnoreCase(sub1)) {
						// System.out.println("month:" + month + "=" + sub1);
						count2 = 1;
					}
				}
				if (startDate.substring(startDate.lastIndexOf("-") + 1, startDate.length()).length() == 4) {
					count3 = 1;
				}
		         
			} else
				System.out.println("Invalid date format");
			// System.out.println(count1+" "+count2+" "+count3);
			if (count1 == 2 && count2 == 1 && count3 == 1) {
				b = true;
			}
			return b;
		}
	//COMPARING YEARS
		public boolean dateCompare(String startDate, String lastDate) {
			boolean b = false;
			if (!(startDate.compareToIgnoreCase(lastDate) <= 0)) {
				b = true;
				System.out.println("Entry date should not be greater than exit date");
			}
			return b;
		}
	}
