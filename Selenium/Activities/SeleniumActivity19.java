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
public class SeleniumActivity19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/alerts");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("confirmation")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert confirmalert = driver.switchTo().alert();
		System.out.println("Alert display:"+confirmalert.getText());
		confirmalert.accept();
		String AlertConfirmation = driver.findElement(By.id("result")).getText();
		System.out.println("Alert acceptancemessage:" +AlertConfirmation);
		//forreject
		driver.findElement(By.id("confirmation")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert display:"+confirmalert.getText());
		confirmalert.dismiss();
		System.out.println("Alert Declinemessage:" +AlertConfirmation);
		driver.quit();
		
	}

}
