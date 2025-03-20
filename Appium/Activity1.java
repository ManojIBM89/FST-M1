package Activities;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import javax.xml.crypto.URIReferenceException;
import io.appium.java_client.AppiumDriver;

public class Activity1 {
    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        // Server Address
        URL serverURL = new URI("http://localhost:4723").toURL();

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    // Test method
    @Test
    public void multiplyTest() {
        // Perform the calculation
    	//Press key 5 in calculator using xpath(Using 1st locator type)
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.calculator2:id/digit_5\"]")).click();
        //Press multiply by using id locator(Using 2nd locator type)
        driver.findElement(AppiumBy.id("op_mul")).click();
        //Press 8 using id locator(Using 3rd locator type)
        driver.findElement(AppiumBy.id("digit_8")).click();
        //Press equals using locator accessibilityID
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
	    // Find the result
	    String result = driver.findElement(AppiumBy.id("result")).getText();
	    // Assertion
	    Assert.assertEquals(result, "40");
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}