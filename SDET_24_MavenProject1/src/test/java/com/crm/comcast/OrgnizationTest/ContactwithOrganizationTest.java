package com.crm.comcast.OrgnizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.ExcelUtility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;
import com.crm.comcast.pomrepositylib.Contacts;
import com.crm.comcast.pomrepositylib.CreatingNewContact;
import com.crm.comcast.pomrepositylib.CreatingNewOrganization;
import com.crm.comcast.pomrepositylib.Home;
import com.crm.comcast.pomrepositylib.Login;
import com.crm.comcast.pomrepositylib.Organizationinfo;
import com.crm.comcast.pomrepositylib.Organizations;

public class ContactwithOrganizationTest {
	@Test
	public void ContactwithOrganization() throws Throwable, IOException {
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
		home_page.getOrganizationlnk().click();

		/* step : 3 click add organization lookup */
		Organizations organizations = new Organizations(driver);
		organizations.getAddUser().click();

		/* step : 4 Creating new organization */

		CreatingNewOrganization New_Organization = new CreatingNewOrganization(driver);
		String Name = eLib.getTestData("Sheet1", 1, 2);
		String randomnum = jLib.randomNum();
		String actualname = Name + randomnum;
		New_Organization.getOrganization_Name().sendKeys(actualname);
		/* Select Industry */

		New_Organization.SelectIndustry();

		/* Select Type */

		New_Organization.SelectType();
		New_Organization.getSavebutton().click();

		/* step : 5 Verify the Organation */

		Organizationinfo organization_info = new Organizationinfo(driver);
		wLib.implcitlyWait(driver, 10);
		String Expectedname = organization_info.getVerifyname().getText();
		if (Expectedname.contains(actualname)) {
			System.out.println(Expectedname + "====> Created suceefully" + "pass");
		} else {
			System.out.println(Expectedname + "====> Not Created suceefully" + "fail");

		}
		home_page.getContactlink().click();
		;
		Contacts contacts = new Contacts(driver);
		contacts.getContactadd().click();
		CreatingNewContact creating_newcontact = new CreatingNewContact(driver);
		creating_newcontact.getLastnamebox().sendKeys(actualname);
		creating_newcontact.getOrgadd().click();

		Organizations organization = new Organizations(driver);
		organization.Child_WindowHandle();
		organization.getSearchtext().sendKeys(actualname);
		organization.getSerachbutton().click();
		organization.getOrgname(actualname).click();
		organization.Parent_windowHandle();

		creating_newcontact.getSavebutton().click();

		home_page.move_element(driver);
		home_page.getSingout();
		driver.close();

	}

}
