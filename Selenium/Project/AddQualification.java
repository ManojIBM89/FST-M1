package HRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddQualification {
	
	static WebDriver driver;
	static Actions action;
	static WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@Test(priority =1)
	@Parameters({"username", "password"})
	public void login_page(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Boolean logged_in = driver.findElement(By.xpath("//*[@id = 'welcome']")).isDisplayed();
		Assert.assertTrue(logged_in);
	}
	
	@Test(priority =2)
	public void add_qualifications() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Qualifications")));
		driver.findElement(By.linkText("Qualifications")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text() = 'Work Experience']")));
		driver.findElement(By.id("addWorkExperience")).click();
		driver.findElement(By.id("experience_employer")).sendKeys("abc Company");
		Thread.sleep(10000);
		driver.findElement(By.id("experience_jobtitle")).sendKeys("Tester");
		WebElement fromDate = driver.findElement(By.id("experience_from_date"));
		fromDate.clear();
		fromDate.sendKeys("2021-03-01");
		WebElement toDate = driver.findElement(By.id("experience_to_date"));
		toDate.clear();
		toDate.sendKeys("2024-01-01");
		driver.findElement(By.id("experience_comments")).sendKeys("Tester Comments");
		driver.findElement(By.id("btnWorkExpSave")).click();
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}

}