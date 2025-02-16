package Activities;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

import org.jspecify.annotations.Nullable;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
public class Activity1 {
	WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	 driver = new FirefoxDriver(); 
	 //Launching the URL
	 driver.get("https://training-support.net");
  }
  @Test(priority=1)
  public void pagetitletest() {
	  System.out.println("Title of the Page is:" +driver.getTitle());
	  Assert.assertEquals(driver.getTitle(),"Training Support");
  }
  @Test(priority=2)
  public void aboutuslink() {
	  driver.findElement(By.linkText("About Us")).click();
	  System.out.println("Title of the New screen is:"+driver.getTitle());
	  Assert.assertEquals(driver.getTitle(),"About Training Support");
  }

@AfterClass
  public void afterClass() {
	  //Closing the browser
	  driver.quit();
  }

}
