package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumActivity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//Opening URL
		driver.get("https://training-support.net");
		//Printing the title of the URL
		System.out.println("Title of the URL page is:" +driver.getTitle());
		//Clicking the About us element
		driver.findElement(By.linkText("About Us")).click();
		//Print the title of the page
		System.out.println("The Title of the new page:" +driver.getTitle());
		//Closing the browser
		driver.close();
		
	}

}
