package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumActivity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//Launch URL
		driver.get("https://training-support.net/webelements/login-form/");
		//Getting the title of the Page
		System.out.println("Title of the page:" +driver.getTitle());
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		driver.findElement(By.xpath("(//*[@class='svelte-1pdjkmx'])[3]")).click();
		System.out.println("New Page Title:" +driver.getTitle());	
		//Closing the browser
		driver.quit();
	}

}
