package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	WebDriver driver;
	@Given("^i enter url in chrome browser\\.$")
	public void i_enter_url_in_chrome_browser() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "D:\\9_30_SeleniumBatch\\downloaded_by_me\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
	    driver.manage().window().maximize();
	    Thread.sleep(6000);
	}

	@When("^i enter username$")
	public void i_enter_username() throws Throwable {
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	}

	@When("^i enter password$")
	public void i_enter_password() throws Throwable {
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
	}

	@When("^i click on login button$")
	public void i_click_on_login_button() throws Throwable {
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
	}

	@Then("^i verify text in url$")
	public void i_verify_text_in_url() throws Throwable {
	    if(driver.getCurrentUrl().contains("dashboard"))
	    {
	    	System.out.println("login success");
	    
	    }
	    else
	    {
	    	System.out.println("login failure");
	    }
	}

	@Then("^i close browser$")
	public void i_close_browser() throws Throwable {
	  driver.close();
	}
}
