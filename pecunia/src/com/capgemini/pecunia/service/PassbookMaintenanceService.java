package com.capgemini.pecunia.service;
import java.util.List;
import com.capgemini.pecunia.entity.Transactions;

public interface PassbookMaintenanceService {
	
	List<Transactions> updatePassbook(String accountID);
	List<Transactions> accountSummary(String accountID,String startDate,String lastDate) throws Exception;
	public boolean dateValidate(String startDate);
	public boolean dateCompare(String startDate, String lastDate);
}
