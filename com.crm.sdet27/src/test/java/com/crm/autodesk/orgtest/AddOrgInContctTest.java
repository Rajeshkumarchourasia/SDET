package com.crm.autodesk.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddOrgInContctTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Get Java Representation Of Physical File
		FileInputStream fis= new FileInputStream("./Data/common.properties");
		
		//Create Object OF Properties File to load all the Properties
		Properties pob= new Properties();
		pob.load(fis);
		
		//Get the Values from CommonData File
		String browser= pob.getProperty("browser");
		String url= pob.getProperty("url");
		String username= pob.getProperty("username");
		String password= pob.getProperty("password");
		
		//Cross Browser Handling
		WebDriver driver= null;
		
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if (browser.equals("edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			driver= new FirefoxDriver();
		}
		
		//Open The Url
		driver.get(url);
		
		//Maximize Browser & Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebDriverWait wait= new WebDriverWait(driver,300);
		
		
		//Login to Vtiger
		driver.findElement(By.name("user_name")).sendKeys((username), Keys.TAB, (password));
		driver.findElement(By.id("submitButton")).click();
		
		//Click on Organisation to add Organsation
		driver.findElement(By.linkText("Organizations")).click();
		
		//Click on + button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Add Organisation Name
		driver.findElement(By.name("accountname")).sendKeys("JagdeshPG07");
		
		//Click On Upper Save Button
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//Thread.sleep(2000);
		
		//Navigation nav= driver.navigate();
		//nav.refresh();
		
		//Click On Contacts To Add Contact & Add the Created Organisation There
		WebElement contact= driver.findElement(By.linkText("Contacts"));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Contacts")));
//		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(contact)));
		//wait.until(ExpectedConditions.elementToBeClickable(contact));
		contact.click();
		
		//Click On Add Button
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		
		//Add Last Name
		driver.findElement(By.name("lastname")).sendKeys("Amitabha7");
		
		//Add Organisation
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif']) [1]")).click();
		
		//Handling Organisation PopUp Window
		String mainId=driver.getWindowHandle();
		
		Set <String> allIds= driver.getWindowHandles();
		
		for(String id: allIds)
		{
			if(!mainId.equals(id))
			{
				driver.switchTo().window(id);
			
				driver.manage().window().maximize();
				
				driver.findElement(By.id("search_txt")).sendKeys("JagdeshPG02");
				
				driver.findElement(By.name("search")).click();
				
				WebElement element= driver.findElement(By.linkText("JagdeshPG02"));
				
				element.click();
				break;
//				Actions act= new Actions(driver);
//				act.moveToElement(element).perform();
			}
			}
		
		//Switching To MainBrowser
		driver.switchTo().window(mainId);
		
		//Clicking Save on Contacts After Adding Organisation
		WebElement save=driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(save));
		save.click();
		
		//Verify If Contact Added Successfully or Not
		String actualElement= "Amitabha7";
		String verify= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(verify.contains(actualElement))
		{
			System.out.println("Contact has been successfully added");
		}
		else
		{
			System.out.println("Not Added");
		}
		
		//Thread.sleep(5000);
		
		//Logout from Vtiger
		WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		act.moveToElement(element).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
	
		//Closing The Browser
		driver.close();
	}
		
	}

