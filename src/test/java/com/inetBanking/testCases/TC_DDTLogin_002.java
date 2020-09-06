package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_DDTLogin_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pass)
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		Logger.info("User name is provided");
		lp.setPassword(pass);
		Logger.info("Password is provided");
		lp.clickSubmit();
		Logger.info("Clicked submit button");
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			Logger.info("Login successfull");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	}

	public boolean isAlertPresent()
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e)
		{
			return false;
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBnking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", rownum);
		
		String logindata[][] = new String[rownum][colnum];
		
		for (int i=1; i<=rownum; i++)
		{
			for (int j=0; j<colnum; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j); 
			}
		}
			
		return logindata;
	}
}
