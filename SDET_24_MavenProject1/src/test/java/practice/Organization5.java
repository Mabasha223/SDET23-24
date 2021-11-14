package practice;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Organization5 {

	@Test
	public void Clicklistbo()
	{
		HashSet<String> hs=new HashSet<String>();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.linkText("Organizations")).click();
			List<WebElement> listbox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[*]/input"));
			for(int i=1;i<listbox.size();i++) {
				String text = listbox.get(i).getText();
				hs.add(text);
			}for(String text1:hs)
			System.out.println(text1);
	}
}
