package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author user
 *
 */
public class FileUtility {

	/**
	 * Used To Get Property Values According to Key Arguments From CommonData Properties File
	 * @param key
	 * @return String Data
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis= new FileInputStream("./Data/common.properties");
		Properties pObj= new Properties();
		pObj.load(fis);
		return pObj.getProperty(key);
			
	}
	
	
}
