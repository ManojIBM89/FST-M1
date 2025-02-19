package HRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DirectoryMenu {

	static WebDriver driver;
	static WebDriverWait wait;
	
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test(priority =1)
	@Parameters({"username", "password"})
	public void login_page(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Boolean logged_in = driver.findElement(By.xpath("//*[@id = 'welcome']")).isDisplayed();
		Assert.assertTrue(logged_in);
//		Thread.sleep(3000);
	}
	
	@Test(priority =2)
	public void DirectoryPageTitle() throws InterruptedException {
		
		WebElement directory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()= 'Directory']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()= 'Directory']")));
		Assert.assertTrue(directory.isDisplayed(), "Directory menu should be displayed");
		Thread.sleep(9000);
		directory.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Search Directory");		
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}
}