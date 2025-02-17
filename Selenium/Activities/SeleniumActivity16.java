package Activities;
import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumActivity16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/selects");
		System.out.println(driver.getTitle());
		WebElement dropdown = driver.findElement(By.xpath("//*[@class='h-10 w-64 rounded-lg border-2 border-black bg-purple-200 px-3 shadow-md transition hover:shadow-lg']"));
		Select singleselect = new Select(dropdown);
		singleselect.selectByVisibleText("Two");
		System.out.println("Selected option:" +singleselect.getFirstSelectedOption().getText());
		singleselect.selectByIndex(3);
		System.out.println("Selected option:" +singleselect.getFirstSelectedOption().getText());
		singleselect.selectByValue("four");
		System.out.println("Selected option:" +singleselect.getFirstSelectedOption().getText());
		//getting options
		java.util.List<WebElement> options = singleselect.getOptions();
		System.out.println("ALL options:");
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		
		driver.quit();
	}
	
	

}
