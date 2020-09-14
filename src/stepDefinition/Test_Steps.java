package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps 
{
	public static WebDriver driver;
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page()
	{
		System.setProperty("webdriver.chrome.driver","D:/Selenium Jars/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://in.yahoo.com/");
	}
	
	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Exception
	{
		Thread.sleep(5000);
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeSelected(By.id("uh-signin")));*/
		driver.findElement(By.id("uh-signin")).click();
	}
	@When("^User enters UserName$")
	public void user_enters_UserName() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("ramana1248");
		Thread.sleep(3000);
		driver.findElement(By.name("signin")).click();
	}
	@When("^User enters Password$")
	public void user_enters_Password() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("mangamma!#1990");
		Thread.sleep(3000);
		driver.findElement(By.name("verifyPassword")).click();
	}
	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable 
	{
		 System.out.println("Login Successfully");
	}
	
	 @When("^User LogOut from the Application$")
	 public void user_LogOut_from_the_Application() throws Throwable 
	 {
		 Actions action = new Actions(driver);
		 //driver.findElement(By.className("uh-menu-btn P(0) Bd(0) Pos(r) "));
		 action.moveToElement(driver.findElement(By.className("uh-menu-btn P(0) Bd(0) Pos(r) "))).build().perform();
		 Thread.sleep(3000);
		 driver.findElement(By.id("uh-signout")).click();
	 }
	 
	 @Then("^Message displayed Logout Successfully$")
	 public void message_displayed_Logout_Successfully() throws Throwable 
	 {
	        System.out.println("LogOut Successfully");
	 }
	
	

}
