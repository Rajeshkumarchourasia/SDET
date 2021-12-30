package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author user
 *
 */
public class JavaUtility {
	
	
	/**
	 * It's used to generate Random Number
	 * @return int data
	 */
	
	public int getRandomNumber()
	{
		Random random= new Random();
		int ranDomNum=random.nextInt(1000);
		return ranDomNum;
	}
	
	
	/**
	 * used to get System date & Time in IST Format
	 * @return String Data
	 */
	
	public String getSystemDateAndTime()
	{
		Date date= new Date();
		String systemDate=date.toString();
		return systemDate;
		
	}
	
	
	/**
	 * used to get Date in the Format of YYYY-MM-DD 
	 * @return String Data
	 */
	
	public String getDateInFormatYYYMMDD()
	{
		Date date = new Date();
		String systemDateAndTime=date.toString();
		
		String YYYY= systemDateAndTime.split(" ")[5];
		int MM= date.getMonth()+1;
		String DD= systemDateAndTime.split(" ")[2];
		
		String formattedDate= YYYY+"-"+MM+"-" +DD;
		return formattedDate;
	}
	
	
	/**
	 * To Verify whether the Given Element is Successfully Added/Modiefied or Not 
	 * @param textInBrowser
	 * @param actualTextEntered
	 * @return String Value
	 */
	public String verify(String browserText, String actualEnteredText)
	{
		String result;
		if(browserText.contains(actualEnteredText))
	{
		result=actualEnteredText+ " is Successfully Added/Modified==>>> PASS";
	}
	else
	{
		result=actualEnteredText+ " is Not Successfully Added/Modified==>>> FAIL";
	}
		return result;
	}

	
	
	
}
