package com.crm.autodesk.genericutility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author user
 *
 */
public class WebDriverUtility {

	
	/**
	 * Used To Invoke ImplicitWait
	 * @param driver
	 */
	public void invokeImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	/**
	 * Used to invoke Explicit Wait by Visibility of Locator Condition
	 * @param driver
	 * @param element
	 */
	public void invokeExplicitWait(WebDriver driver, WebElement element, String enterConditionInSmall)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);

		if(enterConditionInSmall.contains("visibilityof"))
				{
		wait.until(ExpectedConditions.visibilityOf(element));
		}
		
	}
	
	
	
	/**
	 * Used To Move Mouse Pointer to a Certain Location
	 * @param driver
	 * @param location
	 */
	public void moveMouseToLocation(WebDriver driver, WebElement location)
	{
		Actions act= new Actions(driver);
		act.moveToElement(location).perform();
	}
	
	
	
	/**
	 * 
	 * @param listBoxLocation
	 * @param listboxVisibleValue
	 */
	public void selectFromListBox(WebElement Location,String VisibleValue)
	{
		Select s= new Select(Location);
		s.selectByVisibleText(VisibleValue);
		
	}
	
	
	/**
	 * Used to choose between desired Browser for Compatibility Testing
	 * @param browser
	 * @return WebDriver
	 */
	public WebDriver crossBroswerHandling(String browser) 
	{
		WebDriver driver=null;
		
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if (browser.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
		{
			driver= new EdgeDriver();
		}
		return driver;
	}
	
	
	
	public void windowHandles(WebDriver driver, Set <String> allIds, String expectedTitle)
	{
		Iterator <String > it= allIds.iterator();
		
		while(it.hasNext())
		{
			String currentId=it.next();
			driver.switchTo().window(currentId);
			String currentPageTitle=driver.getTitle();
			if(currentPageTitle.contains(expectedTitle))
			{
				break;
				}
			}
	}
	
}
