package com.crm.comcast.genericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author mabasha
 *
 */
public class WebDriverUtility 
{
	/**
	 * This is the implicitly wait generic method.
	 * @param driver
	 * @param time is used here in seconds
	 */
	
	public void implcitlyWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	/**
	 * this generic method is used for explicitly wait.
	 * @param driver
	 * @param time is used here in seconds
	 */
	public void explicitlyWait(WebDriver driver, int time, WebElement locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	//WebDriverWait wait = new WebDriverWait(driver, 30);
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Contacts"))));
	/**
	 * This is a generic method is used to switch windows
	 * @param driver
	 * @param textSearch
	 */
	public void windowSwitch(WebDriver driver, String textSearch)
	{
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it = wh.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(textSearch))
			{
				break;
			}
		}
	}
	
	public void mouseHover(WebDriver driver, WebElement locator)
	{
		Actions a = new Actions(driver);
		WebElement button = locator;
		a.moveToElement(button).perform();
	}
	public WebDriver openbrowser(String browser) 
	{
		WebDriver driver = null;
		if(browser.equals("chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if (browser.equals("firefox")) 
		{
			driver=new FirefoxDriver();
		} 
		return driver;
	}

	public void explicitlyWait(WebDriver driver, int time, String string) {
		// TODO Auto-generated method stub
		
	}
		
		
	}
 

