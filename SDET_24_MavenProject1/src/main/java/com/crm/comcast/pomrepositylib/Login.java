package com.crm.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class Login {
	WebDriver driver;
 
	public Login(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	@FindBy(name ="user_name")
	private WebElement usernameTextb;
	
	@FindBy (name ="user_password")
	private WebElement passwordTextb;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	public WebElement getUsernameEdt() {
		return usernameTextb;
	}

	public WebElement getPasswordEdt() {
		return passwordTextb;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	
	
	
	//login to page 
	public void loginToapp(WebDriver driver,String url,String username,String password,String browser) 
	{
		
		driver.get(url);
		
		usernameTextb.sendKeys(username);
		passwordTextb.sendKeys(password);
		loginBtn.click();
	}
	public void loginToapp(String username,String password) 
	{
		
		
		usernameTextb.sendKeys(username);
		passwordTextb.sendKeys(password);
		loginBtn.click();
	}

	
}
