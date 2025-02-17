package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActivity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		Actions builder = new Actions(driver);
		driver.get("https://training-support.net/webelements/drag-drop");
		System.out.println("Title:" + driver.getTitle());
		WebElement ball = driver.findElement(By.id("ball"));
		WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
		WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
		builder.clickAndHold(ball).moveToElement(dropzone1).pause(2000L).release().build().perform();
		// checking whether the ball moved to dropzone 1
		if (dropzone1.findElement(By.xpath("(//*[@class='dropzone-text svelte-lit24y'])[1]")).getText()
				.equals("Dropped")) {
			System.out.println("Ball Dropped in Dropbox 1");
		}
		builder.clickAndHold(ball).moveToElement(dropzone2).pause(2000L).release().build().perform();
		if (dropzone2.findElement(By.xpath("(//*[@class='dropzone-text svelte-lit24y'])[2]")).equals("Dropped")) {
			System.out.println("Ball Dropped in DropBox 2");
		}
		driver.quit();

	}
}