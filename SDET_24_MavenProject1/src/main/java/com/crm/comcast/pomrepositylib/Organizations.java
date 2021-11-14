

package com.crm.comcast.pomrepositylib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {

/**
 * 
 * @author mabasha
 *
 */
	WebDriver driver;
	public  Organizations(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement AddUser;
	public WebElement getAddUser() {
		return AddUser;
	}
	

	
	@FindBy(name="search_text")
	private WebElement searchtext;
	@FindBy(xpath = "//input[@class='crmbutton small create']")
	private WebElement serachbutton;
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getSearchtext() {
		return searchtext;
	}
	public WebElement getSerachbutton() {
		return serachbutton;
	}
	
	public WebElement getOrgname(String orgname) {
		return driver.findElement(By.xpath("//a[.='"+orgname+"']"));
	}
	
	
	/*
	 * get child_window handle
	 * */
	String pwh,cwh;
	public void Child_WindowHandle() {
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> itr = allwindow.iterator();
		 pwh = itr.next();
		 cwh = itr.next();
		driver.switchTo().window(cwh);
	}
	public void Parent_windowHandle() {
		driver.switchTo().window(pwh);
		
	}
}
