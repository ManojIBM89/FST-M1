package stepDefenitions;

import java.time.Duration;
import java.util.List;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6StepDefenition {
	
	WebDriver driver;
	WebDriverWait wait;
	List<String> tasks;

	@Given("User completes the requirement")
	public void completeRequirement() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://training-support.net/webelements/todo-list");
        driver.manage().window().maximize();
		System.out.println("Given completed");
	}

	@When("User enters the following tasks")
	public void inputTasks(DataTable inputTasks) throws InterruptedException {
		tasks = inputTasks.asList();
		System.out.println(tasks);

		for(String task : tasks) {
			driver.findElement(By.id("todo-input")).sendKeys(task);
			driver.findElement(By.id("todo-add")).click();
			Thread.sleep(2000);
		}
	}

	@Then("Verify results")
	public void verifyResults() {
		String result1 = driver.findElement(By.xpath("//ul//li//h3[contains(text(),'task1')]")).getText();
		String result2 = driver.findElement(By.xpath("//ul//li//h3[contains(text(),'task2')]")).getText();
		String result3 = driver.findElement(By.xpath("//ul//li//h3[contains(text(),'task3')]")).getText();
		
		Assertions.assertEquals(result1, tasks.get(0));
		Assertions.assertEquals(result2, tasks.get(1));
		Assertions.assertEquals(result3, tasks.get(2));
		
		System.out.println("Verification complete");
		driver.quit();
	}
}