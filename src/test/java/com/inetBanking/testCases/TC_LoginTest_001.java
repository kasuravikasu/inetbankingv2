package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("Step-2: Username entered in the text field");
		lp.setPassword(password);
		Logger.info("Step-3: Password entered in the text field");
		lp.clickSubmit();
		Logger.info("Step-4: Clicked Submit button");
		
		//Verifying the homepage title
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage1"))
		{
			Assert.assertTrue(true);
			Logger.info("Result: Home page launched and the title is matching");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			Logger.info("Result: Home page launched but the title is not matching");
		}
	}
}
