package com.crm.autodesk.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContctTest {

	public static void main(String[] args) throws IOException {
		
		//Create Java Representation of Physical File
		FileInputStream fis= new FileInputStream("./Data/common.properties");
		
		//Object Creation Of Properties File to Load All The Properties
		Properties pob = new Properties();
		pob.load(fis);
		
		//Get The Value from CommonData File
		String browser=pob.getProperty("browser");
		String url=pob.getProperty("url");
		String username=pob.getProperty("username");
		String password=pob.getProperty("password");
		
		//Cross Browser Handling
		WebDriver driver= null;
		
		if (browser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if (browser.equals("edge"))
		{
			driver= new EdgeDriver();
		}
		else
			{driver= new FirefoxDriver();
			}
		
		//Data To be Verified
		String actualElement="Kundu";
		
		//Implicit Wait & Browser Maximize
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Login into Vtiger
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys((username), Keys.TAB, (password));
		driver.findElement(By.id("submitButton")).click();
		
		//Enter into Contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click On Create Contact
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		
		//Add LastName
		
		driver.findElement(By.name("lastname")).sendKeys("Kundu");
		
		//Click On Upper Save Button
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]']) [1]")).click();
		
		//Verify Added or Not
		String verifyText = driver.findElement(By.className("dvHeaderText")).getText();
		
		if(verifyText.contains(actualElement))
		{
			System.out.println("Successfully Added: Verified");
		}
		else
		{
			System.out.println("Not Successfully Added: Can't be Verified");
		}
		
		//Move Mouse Pointer To Profile Button near Administrator For Sign out
		WebElement signout=driver.findElement(By.xpath("//span[text()=' Administrator']/../../td[2]"));
		
		Actions act= new Actions(driver);
		act.moveToElement(signout).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Closing the Browser
		driver.close();
	}
}
