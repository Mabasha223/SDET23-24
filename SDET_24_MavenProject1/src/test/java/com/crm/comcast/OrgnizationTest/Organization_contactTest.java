package com.crm.comcast.OrgnizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.Baseclass;
import com.crm.comcast.pomrepositylib.ContactInformation;
import com.crm.comcast.pomrepositylib.Contacts;
import com.crm.comcast.pomrepositylib.CreatingNewContact;
import com.crm.comcast.pomrepositylib.CreatingNewOrganization;
import com.crm.comcast.pomrepositylib.Home;
import com.crm.comcast.pomrepositylib.Organizations;

public class Organization_contactTest extends Baseclass {
	
	@Test(groups= {"Regression","Smoketesting"})
	public void  Organization() throws Throwable, IOException {
		Home home_page = new Home(driver);
		home_page.getOrganizationlnk().click();

		/* step : 2 click add organization lookup */
		Organizations organizations = new Organizations(driver);
		organizations.getAddUser().click();

		/* step : 3 Creating new organization */
		
		CreatingNewOrganization New_Organization = new CreatingNewOrganization(driver);
		String Name = eLib.getTestData("Sheet1", 1, 2);
		String randomnum = jLib.randomNum();
		String actualname = Name + randomnum;
		New_Organization.getOrganization_Name().sendKeys(actualname);
		
	}
	@Test(groups= {"Regression"})
	public void CreatContact() throws Throwable, IOException {
		Home home_page = new Home(driver);
		home_page.getContactlink().click();

		/* Add contact */
		wLib.implcitlyWait(driver, 10);
		Contacts contact = new Contacts(driver);
		contact.getContactadd().click();

		/* Entering with credintials */

		CreatingNewContact creating_newcontact = new CreatingNewContact(driver);
		String Name = eLib.getTestData("Sheet1", 1, 2);
		String randomnum = jLib.randomNum();
		String actualname = Name + randomnum;
		creating_newcontact.getLastnamebox().sendKeys(actualname);
		creating_newcontact.getSavebutton().click();

		/* verify the contact name */

		ContactInformation contactinformation = new ContactInformation(driver);
		String expectedname = contactinformation.getVerifyname().getText();
		if (expectedname.contains(actualname)) {
			System.out.println(actualname + "=======>Creat contact success ===> pass ");
		} else {
			System.out.println(actualname + "=======>Creat contact success ===>failS");

		}
		 
	}
}
