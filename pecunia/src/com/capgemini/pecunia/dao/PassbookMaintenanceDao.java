package com.capgemini.pecunia.dao;

import java.util.List;

import com.capgemini.pecunia.entity.Transactions;

public interface PassbookMaintenanceDao {
	
	public List<Transactions> updatePassbook(String accountID);
	List<Transactions> accountSummary(String accountID,String startDate,String lastDate) throws Exception;
}
