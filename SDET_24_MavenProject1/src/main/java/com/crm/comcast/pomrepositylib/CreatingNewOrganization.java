package com.crm.comcast.pomrepositylib;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.genericUtility.ExcelUtility;

public class CreatingNewOrganization extends ExcelUtility {
	WebDriver driver;
	public CreatingNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	@FindBy(name="accountname") 
	private WebElement Organization_Name;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getNametextBox() {
		return Organization_Name;
	}

	public WebElement getOrganization_Name() {
		return Organization_Name;
	}
	@FindBy(name="industry")
	private WebElement SelectIndustry;
	
  public WebElement getSelectOption() {
		return SelectIndustry;
	}
  @FindBy(name="accounttype")
  private WebElement selectType;

public WebElement getSelectType() {
	return selectType;
}

public void SelectIndustry() throws Throwable, IOException {
	String testIndustry = getTestData("Sheet1", 4,3);
	Select select=new Select(SelectIndustry);
	select.selectByVisibleText(testIndustry);
	  
  }
public void SelectType() throws Throwable, IOException {
	String testtype = getTestData("Sheet1", 4,5);

	Select select=new Select(selectType);
	select.selectByVisibleText(testtype);
	  
  }
}
