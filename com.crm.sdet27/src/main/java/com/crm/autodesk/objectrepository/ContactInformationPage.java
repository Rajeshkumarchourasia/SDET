package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.JavaUtility;

public class ContactInformationPage extends JavaUtility{

	//Locate & Identify The Elements
	
			@FindBy(className="dvHeaderText")
			private WebElement headerText;
			
			
			//Initializing The Elements using Constructor
			
			public ContactInformationPage(WebDriver driver) {
			 PageFactory.initElements(driver, this);
			}


			//Utilization
			public WebElement getHeaderText() {
				return headerText;
			}

		
			//Business Library
			public void verify(String lastName) 
			{
				String contactHeader=headerText.getText();
				String result= verify(contactHeader, lastName);
				System.out.println(result);
				
			}
}
