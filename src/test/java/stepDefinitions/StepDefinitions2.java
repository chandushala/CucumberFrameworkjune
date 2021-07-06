package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
public class StepDefinitions2 {

	WebDriver driver;
	
	@Given("^user enters url in \"([^\"]*)\"$")
	public void user_enters_url_in(String browser) throws Throwable {
	    driver=new ChromeDriver();
		driver.get("http://orangehrm.qedgetech.com/");
	    driver.manage().window().maximize();
	    Thread.sleep(5000);
	}

	@When("^user enters username \"([^\"]*)\"$")
	public void user_enters_username(String username) throws Throwable {
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin");

	}

	@When("^user enters password \"([^\"]*)\"$")
	public void user_enters_password(String password) throws Throwable {
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");

	}

	@When("^user clicks of login button$")
	public void user_clicks_of_login_button() throws Throwable {
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
	}

	@Then("^user verifies text in url$")
	public void user_verifies_text_in_url() throws Throwable {
		if(driver.getCurrentUrl().contains("dashboard"))
	    {
	    	System.out.println("login success");
	    
	    }
	    else
	    {
	    	System.out.println("login failure");
	    }
	}

	@Then("^user closes the browser$")
	public void user_closes_the_browser() throws Throwable {
	    driver.close();
	}
}

