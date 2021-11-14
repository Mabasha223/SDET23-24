package com.crm.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContact {
	WebDriver driver;
	public CreatingNewContact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastnamebox;
	@FindBy(xpath =("//input[@name='account_name']/following-sibling::img"))
			private WebElement OrganizationAdd;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getLastnamebox() {
		return lastnamebox;
	}
	public WebElement getOrgadd() {
		return OrganizationAdd;
	}
	
}
