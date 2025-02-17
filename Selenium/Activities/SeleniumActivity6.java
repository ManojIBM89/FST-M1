package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class SeleniumActivity6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Title of the Program:" + driver.getTitle());
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		checkbox.click();
		System.out.println("checkbox is displayed:" + checkbox.isSelected());
		checkbox.click();
		System.out.println("checkbox is displayed:" + checkbox.isSelected());

		driver.quit();

	}

}
