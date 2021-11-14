package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class FrontEnd_BackEnd_Testing 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException, SQLException 
	{
		ArrayList<String> al = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		//opening blank chrome tab
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//using implicitly wait for findelements and findelements
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//opening webpage
		driver.get("http://localhost:8084/");
		
		//locating username field and username
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		
		//locating password field and password
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/button/span")).click();
		
		System.out.println("Enter Project Name: ");
		String projectName = sc.nextLine();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		
		System.out.println("Enter Project Manager Name: ");
		String projectManager = sc.nextLine();
		driver.findElement(By.name("createdBy")).sendKeys(projectManager);
		
		WebElement we = driver.findElement(By.xpath("/html/body/div[3]/div/div/form/div[2]/div[4]/select"));
		
		Select s = new Select(we);
		List<WebElement> list = s.getOptions();
		for(WebElement clk:list)
		{
			s.selectByIndex(1);
			break;
		}
		driver.findElement(By.xpath("/html/body/div[3]/div/div/form/div[3]/input[2]")).click();
		
		//GUI code ends here
		
		//DB code starts here
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement stat = con.createStatement();
		ResultSet set = stat.executeQuery("select * from project");
		
		int count = 0;
		while(set.next())
		{
			if(set.getString("project_name").equals(projectName)) 
			{
				count++;				
			}
		}
		if(count==1)
		{
			System.out.println("Data is created");
		}
		else
		{
			System.out.println("Data is not created");
		}
		con.close();
	}

}
