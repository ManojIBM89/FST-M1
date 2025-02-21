package Activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activitynew1 {
	AppiumDriver driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		//Initializing the Android
		UiAutomator2Options option = new UiAutomator2Options();
		option.setPlatformName("android");
		option.setAutomationName("UiAutomator2");
		option.setAppPackage("com.android.calculator2");
		option.setAppActivity(".Calculator");
		option.noReset();
		
		URL newURL = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(newURL,option);
		}
	@Test
	public void manojmulTest() {
		//Pressing number 9
		driver.findElement(AppiumBy.id("digit_9")).click();
		//Multiplying click
		driver.findElement(AppiumBy.id("op_mul")).click();
		//Pressing number 10
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		//Pressing equals to
		driver.findElement(AppiumBy.id("eq")).click();
		//Validating the result
		String mulvalue = driver.findElement(AppiumBy.id("result")).getText();
		assertEquals(mulvalue,"90");
	}
	
	@AfterClass
	public void close() {
		//Closing the Browser
		driver.quit();
	}
	
	}
