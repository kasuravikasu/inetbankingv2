package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		//Customer should login first
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("Username provided");
		lp.setPassword(password);
		Logger.info("Password provided");
		lp.clickSubmit();
		Logger.info("Clicked Submit");
		
		//Pausing the program to load
		Thread.sleep(3000);
		
		//Adding new customer
		AddCustomerPage addCust = new AddCustomerPage(driver);
		Logger.info("Adding customer details....");
		addCust.clickToAddNewCustomer();
		addCust.setCustomerName("Ravisankar Reddy");
		Logger.info("Customer name provided");
		addCust.setCustomerGender("male");
		Logger.info("Customer gender provided");
		addCust.setDateOfBirth("10", "11", "1988");
		Logger.info("Customer DOB pdated");
		Thread.sleep(3000);
		addCust.setCustomerAddress("Pathamallayapalem");
		Logger.info("Customer Address updated");
		addCust.setCustomerCity("Guntur");
		Logger.info("Customer city updated");
		addCust.setCustomerState("AP");
		Logger.info("Customer state updated");
		addCust.setCustPin(522004);
		Logger.info("Customer Pincode updated");
		addCust.setCustMobileNumber("9705632849");
		Logger.info("Customer mobile number updated");
		
		String email = RandomString()+"@gmail.com";
		addCust.custEmail(email);
		Logger.info("Customer email updated");
		
		addCust.setPasword("ab@123S");
		Logger.info("Customer password updated");
		addCust.custsubmit();
		Logger.info("Customer detailes submited");
		Thread.sleep(3000);
 
		Logger.info("Validation started...");
		boolean resp = driver.getPageSource().contains("Customer Registered Successfully!!!");

		Logger.info("Customer created successfully"+" "+resp);
		if(resp == true)
		{
			Assert.assertTrue(true);
			Logger.info("Customer created successfully");
		}
		else
		{
			captureScreen(driver, "TC_AddCustomerTest_003");
			Assert.assertTrue(false);
			Logger.warn("Customer not created");
		}
	}
	
}
