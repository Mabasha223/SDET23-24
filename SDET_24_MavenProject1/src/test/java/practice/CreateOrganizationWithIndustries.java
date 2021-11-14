package practice;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.crm.comcast.genericUtility.ExcelUtility;
import com.crm.comcast.genericUtility.FileUtility;

public class CreateOrganizationWithIndustries {

	@Test
	public void createOrgTest(XmlTest xml) throws EncryptedDocumentException, IOException
	{
		FileUtility f = new FileUtility();
		String username = xml.getParameter("username");
		String password = xml.getParameter("password");
		String browser = xml.getParameter("browser");
		String url = xml.getParameter("url");
		
		WebDriver driver = null;
		
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		Random r = new Random();
		int randomNum = r.nextInt(100);
		
		ExcelUtility eu = new ExcelUtility();
		String text = eu.getTestData("data", 1, 2)+"_"+randomNum;
		String indE = eu.getTestData("data", 4, 3);
		String typeA = eu.getTestData("data", 4, 4);
		driver.findElement(By.name("accountname")).sendKeys(text);
		
		WebElement ind = driver.findElement(By.name("industry"));
		Select s = new Select(ind);
		s.selectByValue(indE);
		
		WebElement type = driver.findElement(By.name("accounttype"));
		Select s1 = new Select(type);
		s1.selectByValue(typeA);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String verify = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(verify.contains(text))
		{
			System.out.println("Organization created successfully--!!");
			eu.putTestData("data", 4, 5, "pass");
		}
		else
		{
			System.err.println("Organization not created--!!");
			eu.putTestData("data", 4, 5, "fail");
		}
		
		Actions a = new Actions(driver);
		WebElement button = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(button).perform();
		driver.findElement(By.partialLinkText("Sign Out")).click();
		driver.close();
	}
	}


