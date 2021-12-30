package com.crm.autodesk.objectrepository;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class SearchOrganisationPage extends WebDriverUtility{

	//Locate & Identify The Elements
		
		@FindBy(id="search_txt")
		private WebElement searchBox;
		
		@FindBy(name="search")
		private WebElement searchBtn;
		
				
		//Initializing The Elements using Constructor
		
		public SearchOrganisationPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		}

		
		//Utilization
		
		public WebElement getSearchBox() {
			return searchBox;
		}


		public WebElement getSearchBtn() {
			return searchBtn;
		}
		
		
		//Business Library
		public void selectOrganisation(WebDriver driver, String organisationName)
		{
			
			Set <String> allIds= driver.getWindowHandles();
			
			windowHandles(driver, allIds, "Accounts");
			
			searchBox.sendKeys(organisationName);
			searchBtn.click();
			
			
		}
		
		
		
}
