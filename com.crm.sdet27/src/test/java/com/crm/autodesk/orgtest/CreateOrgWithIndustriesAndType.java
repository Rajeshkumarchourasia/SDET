package com.crm.autodesk.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.crm.autodesk.objectrepository.LoginPage;

public class CreateOrgWithIndustriesAndType {

	public static void main(String[] args) throws Throwable {
		
		//Create Object of Utility class
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		
		//Fetch the values from CommonData File
		String browser= fLib.getPropertyKeyValue("browser");
		String url= fLib.getPropertyKeyValue("url");
		String username =fLib.getPropertyKeyValue("username");
		String password= fLib.getPropertyKeyValue("password");
		
		//Generate Random Number
			int ranDomNum = jLib.getRandomNumber();	
				
		//read the data from Excel File
			String orgName = eLib.getDataFromExcelSheet("org", 5, 2)+ranDomNum;
		String industries= eLib.getDataFromExcelSheet("org",5,3);
		String types= eLib.getDataFromExcelSheet("org", 5,4);
				
		WebDriver driver =crossBroswerHandling(browser);
		
		//objects of POM classes
		LoginPage loginpage = new LoginPage(driver);
		
		//Implicit Wait Handling
		wLib.invokeImplicitWait(driver);
		
		//Open the Browser & Server
		driver.get(url);
		
		//Maximize the Browser
		driver.manage().window().maximize();
		
		//Enter Username & Password
		driver.findElement(By.name("user_name")).sendKeys((username), Keys.TAB, (password));
		
		//Login
		driver.findElement(By.id("submitButton")).click();
		
		//Click on Organizations
		driver.findElement(By.linkText("Organizations")).click();
		
		//Click on Add Organization (+ Sign)
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		
		//Locating Organisation Name TextBox
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		//Loacting Industry CheckBox & Selecting the Option
		WebElement industry= driver.findElement(By.name("industry"));
		
		Select s1= new Select (industry);
		
		s1.selectByVisibleText(industries);
		
		//Locating Type CheckBox & Selecting the Option
		WebElement type=driver.findElement(By.name("accounttype"));
		
		Select s2= new Select (type);
		s2.selectByVisibleText(types);
		
		//Click on Save Button
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//Verify Added or Not
		String industryValue= driver.findElement(By.id("mouseArea_Industry")).getText();
		
		if(industries.equals(industryValue))
		{
			System.out.println("Industry: Energy is Successfully Added");
		}
		
		else
		{
				
			System.out.println("Industry Not Added");
		}
		
		if(types.equals(driver.findElement(By.id("mouseArea_Type")).getText()))
		{
			System.out.println("Type: Press is selected");
		}
		else
		
		{
			System.out.println("Type Not Selected");
		}
		
		String orgNameValue= driver.findElement(By.className("dvHeaderText")).getText();
		System.out.println("OrgName Read="+ orgNameValue);
		
		if(orgNameValue.contains(orgName))
		{
			System.out.println("Organisation Added Successfully===>>> PASS");
		}
		else
		{
			System.out.println("Organisation Not Added Successfully===>>> FAIL");
		}
		
		//Sign Out
		WebElement signOut= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		act.moveToElement(signOut).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Close The Browser
		driver.close();
	}

	private static WebDriver crossBroswerHandling(String browser) {
		// TODO Auto-generated method stub
		return null;
	}
}
