package HRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EmergencyContact {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	@BeforeClass
	
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		
	}
	
	
	@Test(priority =1)
	@Parameters({"username", "password"})
	public void login_page(String username, String password) {
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Boolean logged_in = driver.findElement(By.xpath("//*[@id = 'welcome']")).isDisplayed();
		Assert.assertTrue(logged_in);	
	}
	
	@Test(priority =2)
	public void emergencyContactInfo() {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.linkText("Emergency Contacts")).click();
		List<WebElement> mobileNumber = driver.findElements(By.xpath("//table/tbody/tr"));
		for(WebElement row : mobileNumber) {
			String number = row.findElement(By.xpath("./td[5]")).getText();
			System.out.println(number);
			Reporter.log(number);
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}