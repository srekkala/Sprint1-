package com.capgemini.pecunia.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.pecunia.entity.Transactions;

public class PassbookMaintenanceDaoImplTest {
 PassbookMaintenanceDaoImpl dao=new PassbookMaintenanceDaoImpl();
 	@Test
 	public void updatePassbook_1() {
 		String accountID="123456789012";
 		List<Transactions> result = dao.updatePassbook(accountID);
 		int expectedResult=result.size();
 		int actualResult=2;
  		Assert.assertEquals(expectedResult,actualResult);
}
 	@Test
 	public void updatePassbook_2() {
 		String accountID="123456789012";
 		List<Transactions> result = dao.updatePassbook(accountID);
 		int expectedResult=result.size();
 		int actualResult=2;
  		Assert.assertNotSame(expectedResult,actualResult);
}
}
