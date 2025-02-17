package Activities;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumActivity17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/selects");
		System.out.println(driver.getTitle());
		WebElement selectElement = driver.findElement(By.cssSelector("select.h-80"));
        // Pass the WebElement to the Select object
        Select multiSelect = new Select(selectElement);
        for (int i = 3; i <= 5; i++) {
            multiSelect.selectByIndex(i);

	}
        java.util.List<WebElement> Selectedoptions = multiSelect.getAllSelectedOptions();
        for(WebElement option:Selectedoptions)
        {
        	System.out.println(option.getText());
        }
        driver.quit();

}
}