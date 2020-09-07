package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import freemarker.log.Logger;
public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	//Prerequisit Variable declaration
	
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger Logger;
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br)
	{
		Logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if (br.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (br.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if (br.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\kasuravikasu\\eclipse-workspace\\inetBankingV2\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		Logger.info("Step-1: Base URL launched successfully");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		//driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screnshot taken");		
	}
	
	public String RandomString()
	{
		String genEmail=RandomStringUtils.randomAlphabetic(8);
		return genEmail;
	}
	
	public String RandomNumber()
	{
		String genNumber = RandomStringUtils.randomNumeric(4);
		return genNumber;
	}
}
