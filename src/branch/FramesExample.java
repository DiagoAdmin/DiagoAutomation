package branch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesExample {
	
static WebDriver driver;
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://code.makery.ch/library/dart-drag-and-drop/");
		WebElement id=driver.findElement(By.xpath("//iframe[@height='330px']"));
		driver.switchTo().frame(id);
		WebElement image1=driver.findElement(By.xpath("/html/body/div/img[3]"));
		WebElement trash=driver.findElement(By.xpath("/html/body/div/div"));
		Actions as=new Actions(driver);
		as.dragAndDrop(image1, trash).perform();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div/nav/ul/li[2]/a")).click();
		
	/*allbranches();*/
	}

	public static List<WebElement> allbranches() throws Exception
	{

		List<WebElement>branches=driver.findElements(By.xpath("//div[@class='list-group']"));
		return branches;

}
}
