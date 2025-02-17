package stepDefenitions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Activity2_LoginSteps extends BaseClass {
	@Given("the user is on the login page")
	public void openpage() {
		//Open Login page
		driver.get("https://training-support.net/webelements/login-form");
		//Assert Page Title
		Assertions.assertEquals("Selenium: Login Form",driver.getTitle());
		}
	@When("the user enters username and password")
	public void entercredentials() {
		//entering username and password
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		}
	@And("clicks the submit button")
	public void clicksubmit() {
		//clicksubmit button
		driver.findElement(By.xpath("\"//button[text()='Submit']\"")).click();
	}
	@Then("get the confirmation message and verify it")
	public void confirm_message() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
    	
        String message = driver.findElement(By.cssSelector("h2.mt-5")).getText();
	
        // Assert message
	
        Assertions.assertEquals("Welcome Back, Admin!", message);
	}
	}

