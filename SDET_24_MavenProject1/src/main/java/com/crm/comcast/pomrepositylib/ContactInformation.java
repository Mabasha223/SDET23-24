package com.crm.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
	WebDriver driver;

	public ContactInformation (WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement verifycontactname;
	public WebElement getVerifyname() {
		return verifycontactname;
	}
}
