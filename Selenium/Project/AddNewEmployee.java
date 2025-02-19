package HRM;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddNewEmployee {
	
	static WebDriver driver;
	static Actions action;
	static WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority =1)
	@Parameters({"username", "password"})
	public void login_page(String username, String password) {
//	public void login_page() {
	
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
//		driver.findElement(By.id("txtUsername")).sendKeys("orange");
//		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		Boolean logged_in = driver.findElement(By.xpath("//*[@id = 'welcome']")).isDisplayed();
		Assert.assertTrue(logged_in);
	}
	
	@Test(priority =2)	
	public void select_employeeList() {
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//b[text() = 'PIM']"))).build().perform();
		driver.findElement(By.xpath("//*[text() ='Employee List']")).click();	
		driver.findElement(By.id("btnAdd")).click();
		Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Add Employee");
	}
	
	@DataProvider(name = "Add Employee Details")
	public static Object[][] employeeDetails(){
		return new Object[][] {
			{"Anu", "Balan614", "Anub614", "Welcome2!"}
		};
	}
	
	@Test(priority = 3, dataProvider = "Add Employee Details")
	public void add_Employee(String firstName, String lastName, String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		String id = driver.findElement(By.id("employeeId")).getDomAttribute("value");
		System.out.println(id);
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("re_password")).sendKeys(password);
		driver.findElement(By.id("btnSave")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement idAfterSave = driver.findElement(By.id("personal_txtEmployeeId"));
		wait.until(ExpectedConditions.visibilityOf(idAfterSave));
		System.out.println(idAfterSave.getDomAttribute("value"));
		Assert.assertEquals(id,  idAfterSave.getDomAttribute("value"), "ID after saved employee");
	}
	
	@Test(priority = 4, dataProvider = "Add Employee Details")
	public void search_EmployeeRealData(String firstName, String lastName, String username, String password)  {
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//b[text() = 'PIM']"))).build().perform();
		driver.findElement(By.xpath("//*[text() ='Employee List']")).click();
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(firstName +" " + lastName);
		driver.findElement(By.id("searchBtn")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//table/tbody/tr/td[3]/a")).getText(), firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//table/tbody/tr/td[4]/a")).getText(), lastName);		
		
	}
	
	@Test(priority = 5)
	public void search_EmployeeJunkData()  {
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//b[text() = 'PIM']"))).build().perform();
		driver.findElement(By.xpath("//*[text() ='Employee List']")).click();
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("madhanuu" +" " + "kiruba");
		driver.findElement(By.id("searchBtn")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//table/tbody/tr/td")).getText(), "No Records Found");
		
	}
	
	@Test(priority = 6)
	public void deleteEmployee() throws InterruptedException  {
		
		WebElement searchfield =driver.findElement(By.id("empsearch_employee_name_empName"));
		searchfield.clear();
		searchfield.sendKeys("anu");
		driver.findElement(By.id("empsearch_id")).click();
		driver.findElement(By.id("searchBtn")).click();
		driver.findElement(By.id("ohrmList_chkSelectAll")).click();
		driver.findElement(By.id("btnDelete")).click();
		
		WebElement okButton = driver.findElement(By.id("dialogDeleteBtn"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", okButton);
		
////		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value = 'Ok']")));
////		driver.findElement(By.xpath("//input[@value = 'Ok']")).click();
		Thread.sleep(10000);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}