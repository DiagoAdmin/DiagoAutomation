package branch;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import wait.ImplicitWait;
import config.Reading_Properties;

public class FetchAllBranchesinBranchesGrid {

	public void FetchAllBranches(WebDriver driver) throws InterruptedException 
	{
		
			Reading_Properties rp=new Reading_Properties();
			try {
				rp.LoadProperties(driver);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			ImplicitWait.wait(driver);
			try{
				List<WebElement>branches=driver.findElements(By.xpath("//div[@id='divEnterprises']/div"));

				for(WebElement bran:branches)
				{
					String txt=bran.getText();

			if(!txt.equals("New Branch1"))
			{ 
				driver.findElement(By.xpath(rp.getPropertyValue("CreateBranch"))).click();
				driver.findElement(By.id(rp.getPropertyValue("Branch_Name"))).clear();
				driver.findElement(By.id(rp.getPropertyValue("Branch_Name"))).sendKeys("SamplBranch");
				break;
			}
			else
			{
				System.out.println("branch name exists");
			}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			driver.findElement(By.id(rp.getPropertyValue("Building_Name"))).sendKeys("New Branch");
			driver.findElement(By.xpath(rp.getPropertyValue("Branch_Adress_Next"))).click();
			ImplicitWait.wait(driver);
			/*driver.switchTo().frame(rp.getPropertyValue("AllDays_Frame"));*/
			driver.findElement(By.xpath(rp.getPropertyValue("AllDays_Frame"))).click();
			
	driver.findElement(By.xpath(rp.getPropertyValue("Working_Time_From"))).sendKeys("0");
			driver.findElement(By.xpath(rp.getPropertyValue("Working_Time_To"))).sendKeys("23");
			WebElement dept=driver.findElement(By.xpath(rp.getPropertyValue("Dept")));
			dept.click();
			Actions actions = new Actions(driver);
			int deptvalues= driver.findElements(By.xpath(rp.getPropertyValue("Department"))).size();
			for(int i = 0; i <= deptvalues;i++){
			
			    actions.sendKeys(Keys.DOWN).build().perform();//press down arrow key
			    actions.sendKeys(Keys.ENTER).build().perform();//press enter

			    /*here "position" is , ur desired combo box option position,
				for ex. u want to choose 3rd option,so ur "position" will be 3.*/
			}

			
			
			driver.findElement(By.xpath(rp.getPropertyValue("Dept_Category"))).click();
			ImplicitWait.wait(driver);
			int dept_category=driver.findElements(By.xpath(rp.getPropertyValue("Department_Category"))).size();
			
			for(int i = 0; i <= dept_category;i++){
				
			    actions.sendKeys(Keys.DOWN).build().perform();//press down arrow key
			    actions.sendKeys(Keys.ENTER).build().perform();//press enter

			    /*here "position" is , ur desired combo box option position,
				for ex. u want to choose 3rd option,so ur "position" will be 3.*/
			}
			driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo1"))).click();
			ImplicitWait.wait(driver);
			driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo2"))).click();
			ImplicitWait.wait(driver);
			driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo3"))).click();
			/*wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(rp.getPropertyValue("Branch_Name")), "Time left: 7 seconds"));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(rp.getPropertyValue("Building_Name")), "Time left: 7 seconds"));*/
			
			ImplicitWait.wait(driver);
			
		  
		  }
		
}