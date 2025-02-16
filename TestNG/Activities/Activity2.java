package Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
	WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://training-support.net/webelements/target-practice/");
  }
  @Test
  public void Testcase1() {
	  String Title = driver.getTitle();
	  System.out.println("Title of the Page:"+Title);
	  Assert.assertEquals(Title, "Selenium: Target Practice");
	  }
  @Test
  public void Testcase2() {
	  //This test case is Fail
	  WebElement black = driver.findElement(By.cssSelector("button.black"));
	  Assert.assertTrue(black.isDisplayed());
	  Assert.assertEquals(black.getText(),"black");
  }
  @Test(enabled=false)
  public void Testcase3() {
	//This test cases is skipped
	  System.out.println("Dummy");
  }
  @Test
  public void Testcase4() {
	  //This test case will be skipped
	  throw new SkipException("Skipping the test cases");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
