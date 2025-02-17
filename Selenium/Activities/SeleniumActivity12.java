package Activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumActivity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/dynamic-content");
		System.out.println("Title:" + driver.getTitle());
		driver.findElement(By.id("genButton")).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"));
			String result = driver.findElement(By.id("word")).getText();
			System.out.println("Display as:" + result);	
		driver.quit();
	}

}
