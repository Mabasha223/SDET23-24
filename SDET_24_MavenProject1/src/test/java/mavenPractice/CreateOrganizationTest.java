package mavenPractice;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.ExcelUtility;
import com.crm.comcast.genericUtility.FileUtility;

public class CreateOrganizationTest 
{
	@Test
	public void Org() throws IOException 
	{
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		
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
		driver.findElement(By.name("accountname")).sendKeys(text);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String verify = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(verify.contains(text))
		{
			System.out.println("Organization created successfully--!!");
			eu.putTestData("data", 1, 3, "pass");
		}
		else
		{
			System.err.println("Organization not created--!!");
			eu.putTestData("data", 1, 3, "fail");
		}
		
		Actions a = new Actions(driver);
		WebElement button = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(button).perform();
		driver.findElement(By.partialLinkText("Sign Out")).click();
		driver.close();
	}

}
