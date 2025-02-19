package HRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Orange_HRM {
	
static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	
	@Test
	public void validate_title() {
		String title = driver.getTitle();
		Assert.assertEquals(title,  "OrangeHRM");
	}
	   
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}