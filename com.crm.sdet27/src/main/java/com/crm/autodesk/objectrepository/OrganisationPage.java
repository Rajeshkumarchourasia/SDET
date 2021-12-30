package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

	//Locate & Identify The Elements
	@FindBy(css ="img[title='Create Organization...']")
	private WebElement createOrganisationImg;
	
	
	//Initialising The Elemets using Constructor
	
	public OrganisationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization: Generating Getters
	
	public WebElement getCreateOrganisationImg() {
		return createOrganisationImg;
	}
	
	
	//Business Library
	public void clickOnAddOrganisationLink()
	{
		createOrganisationImg.click();
	}
	
}
