package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.Thread;

public class SeleniumActivity15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/dynamic-attributes");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//*[@class='focus:ring-0 svelte-7bqce9'])[1]")).sendKeys("Manoj");
		driver.findElement(By.xpath("(//*[@class='focus:ring-0 svelte-7bqce9'])[2]")).sendKeys("Manoj@gmail.com");
		driver.findElement(By.xpath("(//*[@class='focus:ring-0 svelte-7bqce9'])[3]")).sendKeys("1999/03/03");
		driver.findElement(By.xpath("(//*[@class='focus:ring-0 svelte-7bqce9'])[4]")).sendKeys("Manoj");
		driver.findElement(By.xpath("//*[@class='font-bold svelte-7bqce9']")).click();
		String result = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Success message:"+result);
		driver.quit();
	}
	

}
