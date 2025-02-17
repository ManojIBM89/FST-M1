package Activities;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumActivity20 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("prompt")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert promtalert = driver.switchTo().alert();
		System.out.println("Alert message:" +promtalert.getText());
		promtalert.sendKeys("Awesome");
		Thread.sleep(5000);
		promtalert.accept();
		String AlertConfirmation = driver.findElement(By.id("result")).getText();
		System.out.println("Alert acceptancemessage:" +AlertConfirmation);
		driver.quit();

	}

}
