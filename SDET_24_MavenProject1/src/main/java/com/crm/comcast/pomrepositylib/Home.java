package com.crm.comcast.pomrepositylib;

import javax.management.loading.PrivateClassLoader;
import javax.swing.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	public  Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		@FindBy(linkText="Organizations")
		private WebElement organizationlnk;
	
		@FindBy(linkText="Contacts")
		private WebElement contactlink;
		
		public WebElement getContactlink() {
			return contactlink;
		}

		public WebElement getOrganizationlnk() {
			return organizationlnk;
		}
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement Administrator;
		
		public WebElement getAdministrator() {
			return Administrator;
		}

		public void move_element(WebDriver driver) {
			this.driver=driver;
			Actions action=new Actions(driver);
			action.moveToElement(Administrator).perform();	
		}
		@FindBy(linkText="Sign Out")
		private WebElement singout;
		public WebElement getSingout() {
			return singout;
		}
}


