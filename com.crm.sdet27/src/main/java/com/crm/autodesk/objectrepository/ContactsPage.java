package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	//Locate & Identify The Elements
	@FindBy(css="img[title='Create Contact...']")
	private WebElement createContactsImg;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveContactsBtn;
		
	//Initialising The Elemets using Constructor
	
		public ContactsPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		}

		//Utilization: Getters Method
		public WebElement getCreateContactsImg() {
			return createContactsImg;
		}
		
		
		
		public WebElement getSaveContactsBtn() {
			return saveContactsBtn;
		}

		//Business Library
		public void clickOnCreateContacts() 
		{
			createContactsImg.click();
		}

		public void clickOnContactSave() 
		{
		saveContactsBtn.click();	
		}
}
