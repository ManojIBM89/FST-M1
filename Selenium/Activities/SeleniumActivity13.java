package Activities;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumActivity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/tables");
		System.out.println(driver.getTitle());
		//Print rows and colums
		List<WebElement> columns = driver.findElement(By.xpath("//*[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/thead/tr/th"));
		List<WebElement> rows = driver.findElement(By.xpath("//*[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody/tr"));
		System.out.println("Rows:" +rows.size);
		System.out.println("Column:" +columns.size);
		//3rd row
		List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[3]/td"));
        System.out.println("Third row cell values: ");
        for(WebElement cell : thirdRow) {
            System.out.println(cell.getText());
        }
        WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value: " + cellValue.getText());
        driver.quit();
		
	}

}
