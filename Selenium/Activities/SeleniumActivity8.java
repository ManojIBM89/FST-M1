package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActivity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		Actions builder = new Actions(driver);
		driver.get(" https://training-support.net/webelements/mouse-events");
		System.out.println("Title of the page:" +driver.getTitle());
		WebElement Cargolock = driver.findElement(By.xpath("(//*[@class='cursor-pointer self-center rounded-lg border-2 border-purple-600 shadow-md transition hover:-translate-y-1 hover:bg-purple-200 hover:shadow-xl svelte-hs12g9'])[1]"));
		WebElement Cargotoml = driver.findElement(By.xpath("(//*[@class='cursor-pointer self-center rounded-lg border-2 border-purple-600 shadow-md transition hover:-translate-y-1 hover:bg-purple-200 hover:shadow-xl svelte-hs12g9'])[2]"));
		WebElement src = driver.findElement(By.xpath("(//*[@class='cursor-pointer self-center rounded-lg border-2 border-purple-600 shadow-md transition hover:-translate-y-1 hover:bg-purple-200 hover:shadow-xl svelte-hs12g9'])[3]"));
		WebElement target = driver.findElement(By.xpath("(//*[@class='cursor-pointer self-center rounded-lg border-2 border-purple-600 shadow-md transition hover:-translate-y-1 hover:bg-purple-200 hover:shadow-xl svelte-hs12g9'])[4]"));
		//Perforning actions
		builder.click(Cargolock).pause(5000L).moveToElement(Cargotoml).pause(5000L).click().build().perform();
		String endresult = driver.findElement(By.id("result")).getText();
		System.out.println("Actions Performed:" +endresult);
		builder.doubleClick(src).pause(5000L).
		contextClick(target).pause(5000L).perform();
		WebElement openbutton = driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"));
		builder.click(openbutton).pause(5000L).build().perform();
		System.out.println("Actions performed 2:" +driver.findElement(By.id("result")).getText());
		driver.quit();
	}

}
