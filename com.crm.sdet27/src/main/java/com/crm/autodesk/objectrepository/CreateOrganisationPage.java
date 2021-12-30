package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrganisationPage extends WebDriverUtility{

	//Locate & Identify The Elements
	@FindBy(name="accountname")
	private WebElement orgNameBox;
	
	@FindBy(name="industry")
	private WebElement industryLst;
	
	@FindBy(name="accounttype")
	private WebElement typeLst;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	
	//Initialize the Elements using Constructor
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization: Generate Getters
	public WebElement getOrgNameBox() {
		return orgNameBox;
	}


	public WebElement getIndustryLst() {
		return industryLst;
	}


	public WebElement getTypeLst() {
		return typeLst;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	//Business Library
	public void createAndSaveOrganisationDetails(String organisationName,String industryName, String typeName)
	{
		orgNameBox.sendKeys(organisationName);
		selectFromListBox(industryLst, industryName);
		selectFromListBox(typeLst, typeName);
		saveBtn.click();
	}
	
	
}
