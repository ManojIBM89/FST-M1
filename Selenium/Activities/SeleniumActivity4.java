package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.Color;


public class SeleniumActivity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/target-practice");
		System.out.println("Title of the Page:" +driver.getTitle());
		String thirdtextvalue = driver.findElement(By.xpath("//*[@class='text-3xl font-bold text-orange-600']")).getText();
		System.out.println("The text in third header is:" +thirdtextvalue);
		Color fifthheadingcolour = Color.fromString(driver.findElement(By.xpath("//*[@class='text-3xl font-bold text-purple-600']")).getCssValue("color"));
		System.out.println("The colour in RGB format:" +fifthheadingcolour.asRgb());
		System.out.println("Actual Color in 5th Heading: " +fifthheadingcolour.asHex());
		String puplebuttonclass = driver.findElement(By.xpath("//button[@class='rounded-xl bg-purple-200 p-2 text-3xl font-bold text-purple-900 svelte-2hb4ib']")).getDomAttribute("class");
		System.out.println("Class properties for purple Header is: " +puplebuttonclass);
		String TextSlate = driver.findElement(By.xpath("//button[@class='rounded-xl bg-slate-200 p-2 text-3xl font-bold text-slate-900 svelte-2hb4ib']")).getText();
		System.out.println("Text in Slate Title:" +TextSlate);
		driver.quit();
		
	}

}
