package HRM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EditUserInfo {
	
	static WebDriver driver;
	static WebDriverWait wait;

	
	@BeforeClass
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
	}
	
	@Test(priority =1)
	@Parameters({"username", "password"})
	public void login_page(String userName, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Boolean logged_in = driver.findElement(By.xpath("//*[@id = 'welcome']")).isDisplayed();
		Assert.assertTrue(logged_in);
	}
	
	
	@Test(priority =2)
	public void editInfo() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.id("btnSave")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("personal_txtEmpFirstName")));
		WebElement firstName = driver.findElement(By.id("personal_txtEmpFirstName"));
		firstName.clear();
		firstName.sendKeys("Anu");
		WebElement lastName = driver.findElement(By.id("personal_txtEmpLastName"));
		lastName.clear();
		lastName.sendKeys("Balan");
		driver.findElement(By.id("personal_optGender_1")).click();
		driver.findElement(By.id("personal_optGender_2")).click();
		WebElement dob = driver.findElement(By.id("personal_DOB"));
		dob.clear();
		dob.sendKeys("1994-04-08");
		WebElement dropdown = driver.findElement(By.id("personal_cmbNation"));
		Select select = new Select(dropdown);
		select.selectByValue("36");
		driver.findElement(By.id("btnSave")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}