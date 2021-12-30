package com.crm.autodesk.genericutility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.objectrepository.HomePage;
import com.crm.autodesk.objectrepository.LoginPage;

/**
 * 
 * @author user
 *
 */

public class BaseClass {

	
	//Objects Of Utility Classes
	public DataBaseUtility dLib= new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib= new JavaUtility();
	public ExcelUtility eLib= new ExcelUtility();
	
	
	public WebDriver driver=null;
	
	
	@BeforeSuite(groups={"smokeSuite","RegressionSuite"})
	public void dbConnection()
	{
		dLib.openDatabase();
		System.out.println("===>>> DataBase Connection Successfull<<<===");
	}
	
	@Parameters("browser")
	@BeforeClass(groups={"smokeSuite","RegressionSuite"})
	public void launchBrowser(String browser) throws Throwable
	{
		//String browser= fLib.getPropertyKeyValue("browser");
		driver=wLib.crossBroswerHandling(browser);
		String url= fLib.getPropertyKeyValue("url");
	
		wLib.invokeImplicitWait(driver);
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Browser Launch Successful");
	}
	
	@BeforeMethod(groups={"smokeSuite","RegressionSuite"})
	public void loginToApp() throws Throwable
	{
		String username =fLib.getPropertyKeyValue("username");
		System.out.println("username read="+username);
		String password=  fLib.getPropertyKeyValue("password");
		System.out.println("password read="+password);
		
		//Login
		LoginPage loginPage= new LoginPage(driver);
		loginPage.logIn(username, password);
		System.out.println("Login Successful");		
	}
	
	@AfterMethod(groups={"smokeSuite","RegressionSuite"})
	public void logOutOfApp()
	{
		HomePage homePage= new HomePage(driver);
		homePage.signOut(driver);
		System.out.println("Logout Successful");
	}
	
	@AfterClass(groups={"smokeSuite","RegressionSuite"})
	public void closeBrowser()
	{
		driver.close();
		System.out.println("Browser Close Successful");
	}
	
	@AfterSuite(groups={"smokeSuite","RegressionSuite"})
	public void closeDbConnection()
	{
		dLib.closeDatabase();
		System.out.println("DB Connection Closed Successfully");
	}
	
}

