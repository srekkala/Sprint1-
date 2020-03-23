package com.capgemini.pecunia.dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.capgemini.pecunia.entity.Transactions;

public class PassbookMaintenanceDaoImpl implements PassbookMaintenanceDao {
	List<Transactions> transactionList=new ArrayList<Transactions>();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
   
	
	public PassbookMaintenanceDaoImpl() {
		//predefined transactions
				Transactions transaction1 = new Transactions("123456789012","16-MAR-2020",2000);
		    	transactionList.add(transaction1);
				Transactions transaction2 = new Transactions("123456789012","17-MAR-2020",3000);
		    	transactionList.add(transaction2);
		    	}
	public void validationCheck(final String accountID) {
		
        if(accountID.length()!=12) {
        	throw new IncorrectAccountNoException("Incorrect account Id number=" + accountID);
        }
              
	}
		
	public List<Transactions> updatePassbook(String accountID) {
		validationCheck(accountID);
    	//displaying 
        return transactionList;
        
    }
	
	public List<Transactions> accountSummary(String accountID,String startDate,String lastDate) throws Exception{
		
		int count=0;
		Date startdate=formatter.parse(startDate);
		Date lastdate = formatter.parse(lastDate);
		ArrayList<Transactions> al = new ArrayList<Transactions>();
			for (Transactions tr : transactionList) {
			Date date = formatter.parse(tr.getDate());
			
			if (tr.getAccount_ID().equals(accountID) && date.after(startdate) && date.before(lastdate)) {
				al.add(tr);
				count=count+1;
			}
		}

		System.out.println("Total number of transactions are:" +count);
		return al;

	}
	}
