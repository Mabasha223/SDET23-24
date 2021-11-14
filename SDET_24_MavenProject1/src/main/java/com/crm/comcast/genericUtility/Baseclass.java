package com.crm.comcast.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.comcast.pomrepositylib.Home;
import com.crm.comcast.pomrepositylib.Login;

public class Baseclass {
	
	public WebDriver driver;
	
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();

	@BeforeSuite(groups= {"Regression","Smoketesting"})
	public void ConfigDataBase() 
	{
		System.out.println("Connect to Db=====");
	}
	//@Parameters(value="browser")
  @BeforeClass(groups= {"Regression","Smoketesting"})
  	public void ConfigLunchBrowser() throws Throwable
  {
	  System.out.println("open the browser=====>");
	String browser = fLib.getProppertyKeyValue("browser");
		 driver = wLib.openbrowser(browser);
		 wLib.implcitlyWait(driver, 30);

  } 
  
	@BeforeMethod(groups= {"Regression","Smoketesting"})
	public void  ConfigLogin() throws Throwable 
	{
		System.out.println("Login to page=====>");
		String username = fLib.getProppertyKeyValue("username");
		String password = fLib.getProppertyKeyValue("password");
		String browser = fLib.getProppertyKeyValue("browser");
		String url = fLib.getProppertyKeyValue("url");
		
		/* step : 1 Login to app with cradentials */

		Login login_page = new Login(driver);
		login_page.loginToapp(driver, url, username, password, browser);
	}
	@AfterMethod(groups= {"Regression","Smoketesting"})
	public void ConfigSignOut()
	{
		System.out.println("SignOut======>");
		Home   home_page=new Home(driver);
		home_page.move_element(driver);
		home_page.getSingout().click();
		System.out.println("sign out the application");
	}
	@AfterClass(groups= {"Regression","Smoketesting"})
	public void ConfigCloseBrowser()
	{
		System.out.println("close Browser===>");
		driver.close();
		System.out.println("close the browser");
	}
	@AfterSuite(groups= {"Regression","Smoketesting"})
	public void ConfigCloseDb()
	{
		System.out.println("close the database..");
	}
}
