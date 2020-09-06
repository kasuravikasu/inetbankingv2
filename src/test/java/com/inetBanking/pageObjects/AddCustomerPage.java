package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how = How.NAME, using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how = How.NAME, using="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how = How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txtMobileNumber;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;

	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;
	
	@CacheLookup
	@FindBy(how = How.NAME, using= "res")
	WebElement btnReset;
	
	public void clickToAddNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	
	public void setCustomerName(String cName)
	{
		txtCustomerName.clear();
		txtCustomerName.sendKeys(cName);
	}
	
	public void setCustomerGender(String cgender)
	{
		rdGender.click();
	}
	
	public void setDateOfBirth(String DD, String MM, String YYYY)
	{
		txtdob.sendKeys(DD);
		txtdob.sendKeys(MM);
		txtdob.sendKeys(YYYY);
	}
	
	public void setCustomerAddress(String custAdr)
	{
		txtaddress.clear();
		txtaddress.sendKeys(custAdr);
	}
	
	public void setCustomerCity(String cty)
	{
		txtCity.clear();
		txtCity.sendKeys(cty);
	}
	
	public void setCustomerState(String cState)
	{
		txtState.clear();
		txtState.sendKeys(cState);
	}
	
	public void setCustPin(int cpin)
	{
		txtPin.clear();
		txtPin.sendKeys(String.valueOf(cpin));
	}
	
	public void setCustMobileNumber(String phoneNumber)
	{
		txtMobileNumber.clear();
		txtMobileNumber.sendKeys(phoneNumber);
	}
	
	public void custEmail(String cEmail)
	{
		txtemailid.clear();
		txtemailid.sendKeys(cEmail);
	}
	
	public void setPasword(String passcode)
	{
		txtpassword.clear();
		txtpassword.sendKeys(passcode);
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}
	
	public void clickReset()
	{
		btnReset.click();
	}
}
