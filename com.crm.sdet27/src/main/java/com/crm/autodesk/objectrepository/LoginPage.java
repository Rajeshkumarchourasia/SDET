package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Locate & Identify Elements & Declaring them as Private
	
	@FindBy(name= "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name= "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id ="submitButton")
	private WebElement loginBtn;
	
	
	//Initialize The Elements using Constructors
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization: Generate Getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}


	public WebElement getPasswordEdt() {
		return passwordEdt;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//Business Library
	public void logIn(String userName, String password)
	{
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
}
