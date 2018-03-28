package StepActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest 
{
	WebDriver driver;
	
	@Given("Open Chrome browser and Url")
	public void launchapplication()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\swaroopg\\eclipse-workspace\\Naukri\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/");
	}
	
	
	@When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enterdata(String uname,String pwd) throws InterruptedException
	{
		driver.findElement(By.id("login-email")).sendKeys(uname);
		driver.findElement(By.id("login-password")).sendKeys(pwd);
		Thread.sleep(2000);
		
	}
	
	@Then("Click on login button")
	public void login()
	{
		driver.findElement(By.id("login-submit")).click();
		
	}
	
	@Then("Application should close")
	public void close()
	{
		driver.quit();
		
	}

}
