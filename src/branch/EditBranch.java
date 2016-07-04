package branch;

import java.awt.Window;
import java.io.IOException;







import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import config.Reading_Properties;
import wait.ImplicitWait;

public class EditBranch {
	WebDriver driver;
	Reading_Properties rp=new Reading_Properties();
	public void Edit_Branch(WebDriver driver) throws Exception
	{
		try 
			{
				rp.LoadProperties();
			}
		catch (IOException e) 
			{
	
				e.printStackTrace();
	
			}
WebElement ele=driver.findElement(By.xpath(rp.getPropertyValue("Group")));
ele.click();
ImplicitWait.wait(driver);
driver.findElement(By.xpath(rp.getPropertyValue("Branches"))).click();
ImplicitWait.wait(driver);
WebElement br=driver.findElement(By.xpath(".//*[@id='divEnterprises']/div[1]/div/div[4]/a/span"));
Actions as=new Actions(driver);
as.moveToElement(br).perform();
ImplicitWait.wait(driver);
/*JOptionPane.showMessageDialog(null, By.xpath(".//*[@id='webuiPopover0']/div[2]/div/ul/li[1]/a"));*/
JavascriptExecutor Executor = (JavascriptExecutor)driver;
Executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='divEnterprises']/div[1]/div/div[4]/a/span")));
/*driver.findElement(By.xpath(".//*[@id='webuiPopover0']/div[2]/div/ul/li[1]/a")).click();*/
ImplicitWait.wait(driver);
ImplicitWait.wait(driver);

}

}
