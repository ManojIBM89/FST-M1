package Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	WebDriver driver;
   @BeforeClass
  public void beforeClass() {
	   driver=new FirefoxDriver();
	   driver.get("https://training-support.net/webelements/login-form/");
  }
  @Test
  public void Test() {
	  //Finding user name and password element
	  WebElement username = driver.findElement(By.id("username"));
	  WebElement password = driver.findElement(By.id("password"));
	  //Entering credentials to user name and password
	  username.sendKeys("admin");
	  password.sendKeys("password");
	  //click login button
	  driver.findElement(By.xpath("//button[text()='Submit']")).click();
	  //Read Login message
	  String Loginmessage = driver.findElement(By.xpath("//*[@class='mt-5 text-center text-4xl font-semibold text-gray-800']")).getText();
	  System.out.println("Login message is:"+Loginmessage);
	  Assert.assertEquals(Loginmessage,"Welcome Back, Admin!");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
