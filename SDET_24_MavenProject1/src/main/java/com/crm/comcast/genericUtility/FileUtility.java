package com.crm.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author mabasha
 *
 */
public class FileUtility 
{
	/**
	 * used to get the data from properties file bases on key 
	 * @param key 
	 * @return the value of the key in the form of string 
	 * @throws IOException
	 */
	public  String getProppertyKeyValue(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./data/commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
