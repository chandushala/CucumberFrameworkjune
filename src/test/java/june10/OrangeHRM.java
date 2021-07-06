package june10;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class OrangeHRM {
  
	WebDriver driver;
	String node=" http://192.168.43.160:5678/wd/hub";
	DesiredCapabilities cap;
	@Parameters({"browser"})
	@BeforeTest
	  public void setup(String brw) throws MalformedURLException
	{
		cap=new DesiredCapabilities();
		if (brw.equalsIgnoreCase("chrome"))
		{
			Reporter.log("running on chrome",true);
			cap.setBrowserName("chrome");
			driver=new RemoteWebDriver(new URL(node), cap);
		}
		else if (brw.equalsIgnoreCase("firefox"))
		{
			cap.setBrowserName("firefox");
			driver=new RemoteWebDriver(new URL(node), cap);
		}
	}
	
	@Test(dataProvider = "dp")
	public void verifylogin	(String username, String password) throws Throwable
	{
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().window().maximize();
		Thread.sleep(6000);
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(5000);
		if(driver.getCurrentUrl().contains("dashboard"))
		{
			Reporter.log("login success",true);
		}
		else
		{
			Reporter.log("login fail",true);
		}
	}

  @DataProvider
  public Object[][] dp() {
	  Object login[][]=new Object[4][2];
		login[0][0]="Admin";
		login[0][1]="Qedge123!@#";
		login[1][0]="Admin";
		login[1][1]="test";
		login[2][0]="Admin2";
		login[2][1]="Qedge123!@#";
		login[3][0]="Admin";
		login[3][1]="Qedge123!@#";
		return login;
		

    
  }
  

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
