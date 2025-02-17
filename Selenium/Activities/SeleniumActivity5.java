package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumActivity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Title of the Program:" + driver.getTitle());
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		driver.findElement(By.xpath("(//*[@class='svelte-sfj3o4'])[1]")).click();
		System.out.println("checkbox is displayed:" + checkbox.isDisplayed());
		driver.findElement(By.xpath("(//*[@class='svelte-sfj3o4'])[1]")).click();
		System.out.println("checkbox is displayed:" + checkbox.isDisplayed());

		driver.quit();

	}

}
