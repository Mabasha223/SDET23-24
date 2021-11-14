package com.crm.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationinfo {
	WebDriver driver;
	public Organizationinfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;	
	}
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement verifyname;
	public WebElement getVerifyname() {
		return verifyname;
	}
}
