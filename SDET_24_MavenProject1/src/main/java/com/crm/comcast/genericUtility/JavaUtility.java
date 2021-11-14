package com.crm.comcast.genericUtility;

import java.util.Random;

/**
 * 
 * @author mabasha
 *
 */
public class JavaUtility 
{
	/**
	 * This method is used for generate random number
	 */
	public static  String randomNum()
	{
		Random r = new Random();
		int randomN = r.nextInt(10000);
		return ""+randomN;
	}
/**
 * this method used to current data
 */
}
