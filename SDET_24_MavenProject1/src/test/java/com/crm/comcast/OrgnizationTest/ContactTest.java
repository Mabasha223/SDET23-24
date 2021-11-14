package com.crm.comcast.OrgnizationTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.ExcelUtility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;
import com.crm.comcast.pomrepositylib.ContactInformation;
import com.crm.comcast.pomrepositylib.Contacts;
import com.crm.comcast.pomrepositylib.CreatingNewContact;
import com.crm.comcast.pomrepositylib.CreatingNewOrganization;
import com.crm.comcast.pomrepositylib.Home;
import com.crm.comcast.pomrepositylib.Login;
import com.crm.comcast.pomrepositylib.Organizations;

public class ContactTest {
	@Test
	public void Contact_Test() throws Throwable {

		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();

		String username = fLib.getProppertyKeyValue("username");
		String password = fLib.getProppertyKeyValue("password");
		String browser = fLib.getProppertyKeyValue("browser");
		String url = fLib.getProppertyKeyValue("url");

		/* step : 1 Login to app with cradentials */

		WebDriver driver = wLib.openbrowser(browser);
		Login login_page = new Login(driver);
		login_page.loginToapp(driver, url, username, password, browser);

		/* step : 2 Clicking the organization link */

		Home home_page = new Home(driver);
		home_page.getContactlink().click();

		/* Add contact */
		Contacts contact = new Contacts(driver);
		contact.getContactadd().click();

		/* Entering with credintials */

		CreatingNewContact creating_newcontact = new CreatingNewContact(driver);
		String Name = eLib.getTestData("Sheet1", 1, 2);
		String randomnum = jLib.randomNum();
		String actualname = Name + randomnum;
		creating_newcontact.getLastnamebox().sendKeys(actualname);
		creating_newcontact.getSavebutton().click();

		/* verify the contactname */

		ContactInformation contactinformation = new ContactInformation(driver);
		String expectedname = contactinformation.getVerifyname().getText();
		if (expectedname.contains(actualname)) {
			System.out.println(actualname + "=======>Creat contact success ===> pass ");
		} else {
			System.out.println(actualname + "=======>Creat contact success ===>failS");

		}
		home_page.move_element(driver);
		home_page.getSingout();
		driver.close();

	}

}
