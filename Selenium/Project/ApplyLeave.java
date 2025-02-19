package HRM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ApplyLeave {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	@BeforeClass
	
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	
	@Test (priority =1)
	@Parameters({"username", "password"})
	public void login_page(String username, String password) {
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Boolean logged_in = driver.findElement(By.xpath("//*[@id = 'welcome']")).isDisplayed();
		Assert.assertTrue(logged_in);	
	}
	
	@Test (priority =2)
	public void applyLeave() {
		driver.findElement(By.linkText("Apply Leave")).click();
		Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Apply Leave");
		WebElement dropdown = driver.findElement(By.tagName("select"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("DayOff");
		WebElement fromDate = driver.findElement(By.id("applyleave_txtFromDate"));
		fromDate.clear();
		fromDate.sendKeys("2025-01-19");
		
		WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
		toDate.clear();
		toDate.sendKeys("2025-02-15");
		
		driver.findElement(By.id("applyleave_txtComment")).sendKeys("Testing Purpose");
		driver.findElement(By.id("applyBtn")).click();
	}
	
	@Test (priority = 3)
	public void validateStatus() throws InterruptedException {
		driver.findElement(By.linkText("My Leave")).click();
		Thread.sleep(10000);
		String status = driver.findElement(By.xpath("//table/tbody/tr/td[6]")).getText();
		if(status.contains("Pending Approval")) {
				System.out.println("Your leave status is still pending for Approval");
				Reporter.log("Your leave status is still pending");
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}