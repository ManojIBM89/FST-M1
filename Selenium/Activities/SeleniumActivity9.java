package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActivity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		Actions builder = new Actions(driver);
		driver.get("https://training-support.net/webelements/keyboard-events");
		System.out.println("Title:" +driver.getTitle());
		builder.sendKeys("Selenium").pause(2000L).build().perform();
		String textentered = driver.findElement(By.xpath("//*[@class='mt-3 text-center text-4xl font-semibold text-black']")).getText();
		System.out.println("Entered Value:" +textentered);
		driver.quit();

	}

}
