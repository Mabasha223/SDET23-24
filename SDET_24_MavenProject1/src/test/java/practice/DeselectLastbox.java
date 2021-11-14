package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class DeselectLastbox 
{
	@Test
	public void Clicklistbo()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.linkText("Organizations")).click();
			List<WebElement> listbox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[*]/input"));
		listbox.get(listbox.size()-1).click();
	}
}



