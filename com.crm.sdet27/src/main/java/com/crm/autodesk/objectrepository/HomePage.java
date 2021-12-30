package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	//Locate & Identify Elements and Declare Them as Private
	
	@FindBy(linkText="Organizations")
	private WebElement organisationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(linkText="Documents")
	private WebElement documentsLnk;
	
	@FindBy(linkText="Email")
	private WebElement emailLnk;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleTicketsLnk;
	
	@FindBy(linkText="Dashboard")
	private WebElement dashboardLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	
	//Initialize The Elements using Constructor
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization: Creating Getters
	
	public WebElement getOrganisationsLnk() {
		return organisationsLnk;
	}


	public WebElement getContactsLnk() {
		return contactsLnk;
	}


	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}


	public WebElement getProductsLnk() {
		return productsLnk;
	}


	public WebElement getDocumentsLnk() {
		return documentsLnk;
	}


	public WebElement getEmailLnk() {
		return emailLnk;
	}


	public WebElement getTroubleTicketsLnk() {
		return troubleTicketsLnk;
	}


	public WebElement getDashboardLnk() {
		return dashboardLnk;
	}


	public WebElement getAdministratorImg() {
		return administratorImg;
	}


	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	
	//Business Library
	public void clickOnOrganisationsLink()
	{
		organisationsLnk.click();
	}
	
	public void clickOnContactsLink()
	{
		contactsLnk.click();
	}
	
	public void clickOnOpportunitiesLnk() {
		 opportunitiesLnk.click();
	}


	public void clickOnProductsLnk() {
		 productsLnk.click();
	}


	public void clickOnDocumentsLnk() {
		 documentsLnk.click();
	}


	public void clickOnEmailLnk() {
		 emailLnk.click();
	}


	public void clickOnTroubleTicketsLnk() {
		 troubleTicketsLnk.click();
	}


	public void clickOnDashboardLnk() {
		 dashboardLnk.click();
	}

	public void signOut(WebDriver driver) {
		moveMouseToLocation(driver, administratorImg);
		signOutLnk.click();
	}
	

	
}
