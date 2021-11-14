package com.crm.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {
	WebDriver driver;
	public Contacts(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement contactadd;
	private WebElement nametextBox;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public WebElement getContactadd() {
		return contactadd;
	}
	public WebDriver getDriver() {
		return driver;
	}
	
	
	
	
}
