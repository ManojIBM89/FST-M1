package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumActivity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Title of the page:" +driver.getTitle());
		WebElement inputfield = driver.findElement(By.id("textInput"));
		System.out.println("Display whether the field is enabled:" +inputfield.isEnabled());
		driver.findElement(By.id("textInputButton")).click();
		System.out.println("Display whether the field is enabled:" +inputfield.isEnabled());
		driver.quit();

	}

}
