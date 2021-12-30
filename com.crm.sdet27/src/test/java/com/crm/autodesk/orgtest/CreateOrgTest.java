package com.crm.autodesk.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException {
		
	//Get Java Representation of Physical File
		FileInputStream fis= new FileInputStream("./data/common.properties");
		
	//Create an Object of Property class to load files
		Properties pob= new Properties();
		pob.load(fis);
		
	//Read The Value of CommonData File
		String browser= pob.getProperty("browser");
		String url= pob.getProperty("url");
		String username= pob.getProperty("username");
		String password= pob.getProperty("password");
		
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Organizations")).click();
	
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
	driver.findElement(By.className("detailedViewTextBox")).sendKeys("Rajesh");
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]']) [1]")).click();
	
	driver.close();
	
	
	
	}
	
}
