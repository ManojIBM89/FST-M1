package HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeaderImageValidation {
	
static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	
	@Test
	public void validate_HeaderImage_url() {
		String url = driver.findElement(By.xpath("//div[@id = 'divLogo']/img")).getDomAttribute("src");
		System.out.println("URL of the header image: " +url);
		Reporter.log(url);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}