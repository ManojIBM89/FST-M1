package Activities;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumActivity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Title:" +driver.getTitle());
		WebElement togglecheckbox = driver.findElement(By.xpath("(//*[@class='svelte-sfj3o4'])[1]"));
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		System.out.println("Checkbox displays:" +checkbox.isDisplayed());
		togglecheckbox.click();
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		System.out.println("After 1st click:" +checkbox.isDisplayed());
		togglecheckbox.click();
		wait.until(ExpectedConditions.visibilityOf(checkbox));
		System.out.println("After 2nd click:" +checkbox.isDisplayed());
		driver.quit();
	}

}
