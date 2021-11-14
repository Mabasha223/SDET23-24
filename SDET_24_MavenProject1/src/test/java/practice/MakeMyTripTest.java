package practice;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MakeMyTripTest 
{
	
	
	@Test
	public void Booking() throws Throwable 
	{
		
		
		Date dateobj=new Date();
		String date = dateobj.toString();
		System.out.println(date);
		String[] today = date.split(" ");
		String day=today[0];
		String month=today[1];
		String actualldate=today[2];
		String year=today[5];
		
		//Lunching Browser
		WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		//Navigate to Application
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//div[@data-cy='outsideModal']")).click();
		
		//Selecting Src
		Thread.sleep(2000);
		WebElement src = driver.findElement(By.id("fromCity"));
		src.sendKeys("BOM");
		Thread.sleep(3000);
		src.findElement(By.xpath("//div[.='BOM']")).click();
		
	
		
		
		//selecting dst
	WebElement dst = driver.findElement(By.xpath("//input[@placeholder='To']"));
		dst.sendKeys("MAA");
		Thread.sleep(3000);
		dst.findElement(By.xpath("//div[.='MAA']")).click();
		
		
		//selecting date
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		 WebElement depature = driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10']"));
		 depature.click();
			Thread.sleep(2000);
		// String bookingdate = day+" "+month+" "+actualldate+" "+year;
		WebElement depaturedate = driver.findElement(By.xpath("//div[@aria-label='Fri Nov 19 2021']"));
		depaturedate.click();
		
		
		
	//Thu Nov 11 2021
	//search button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Search']")).click();
	}

}
