package com.crm.comcast.contacttest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.comcast.genericUtility.ExcelUtility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;


public class CreateContactTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		
		//creating objects for all generic methods
		ExcelUtility eu = new ExcelUtility();
		FileUtility f = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		//fetching data from property file
		String username = f.getProppertyKeyValue("username");
		String password = f.getProppertyKeyValue("password");
		String browser = f.getProppertyKeyValue("browser");
		String url = f.getProppertyKeyValue("url");
		
		//Declaration and initialization of browser
		WebDriver driver = null;
		
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		wLib.implcitlyWait(driver, 30);
		
		//opening webpage 
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//creating Organization starts from here
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//creating unique org name and entering in text field
		String orgName = eu.getTestData("contact", 1, 1)+"_"+jLib.randomNum();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verifying org record is created or not
		String verifyOrg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(verifyOrg.contains(orgName))
		{
			System.out.println("Organization created successfully--!!");
			eu.putTestData("contact", 1, 3, "Pass");
		}
		else
		{
			System.err.println("Organization not created--!!");
			eu.putTestData("contact", 1, 3, "Fail");
		}
		
		// waiting to load page properly and contacts module to be visible on the page
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Contacts"))));
		//organization module ends here
		
		//contact page coding beings from here
		// clicking in contacts module tab
		driver.findElement(By.linkText("Contacts")).click();
		
		//clicking on create new contact "+" icon
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//generating unique contact name and entering in last name text field
		String contactName = eu.getTestData("contact", 1, 2)+"_"+jLib.randomNum();
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		
		//clicking on org name lookup button
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//switching control from parent window to child window
		wLib.windowSwitch(driver, "Accounts&action");
		
		//entering previously created org name in search text filed and clicking on search button
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		
		//selecting searched link from the search result
		driver.findElement(By.linkText(orgName)).click();
		
		//switching back to parent window
		wLib.windowSwitch(driver, "Accounts&action");
		
		//clicking on save button to save the created contact
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verifying that contact is created or not
		String verifyContact = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(verifyContact.contains(contactName))
		{
			System.out.println("Contact created successfully--!!");
			eu.putTestData("contact", 1, 4, "Pass");
		}
		else
		{
			System.err.println("Contact not created--!!");
			eu.putTestData("contact", 1, 4, "Fail");
		}
		//creating contact ends here
		
		//clicking on sign out and closing the browser
		wLib.mouseHover(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));

		driver.findElement(By.partialLinkText("Sign Out")).click();
		driver.close();
	}
}
