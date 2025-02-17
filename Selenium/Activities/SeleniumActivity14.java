package Activities;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumActivity14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/tables");
		System.out.println(driver.getTitle());
		List<WebElement> columns = driver.findElement(By.xpath("//*[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/thead/tr/th"));
		List<WebElement> rows = driver.findElement(By.xpath("//*[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody/tr"));
		System.out.println("Rows:" +rows.size);
		System.out.println("Column:" +columns.size);
		//Book name in the 5th row
		List<WebElement> fifthbook = driver.findElement(By.xpath("//*[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody/tr[5]/td[2]"));
		System.out.println("5th row book name:" +fifthbook.gettext());
		// Sort the table
        driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th[5]")).click();

        // Print the cell value of the second row and second column again
        cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
        System.out.println("Book Name after sorting: " + cellValue.getText());
        driver.quit();
	}

}
