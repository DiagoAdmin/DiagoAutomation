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

public class create_branch {
	public void Create_Branch(WebDriver driver) throws InterruptedException
	  {
		Reading_Properties rp=new Reading_Properties();
		try {
			rp.LoadProperties(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImplicitWait.wait(driver);
		driver.findElement(By.xpath(rp.getPropertyValue("Branches"))).click();
		ImplicitWait.wait(driver);
		FetchAllBranchesinBranchesGrid FABG=new FetchAllBranchesinBranchesGrid();
		FABG.FetchAllBranches(driver);
		driver.findElement(By.xpath(rp.getPropertyValue("CreateBranch"))).click();
		ImplicitWait.wait(driver);
		driver.findElement(By.id(rp.getPropertyValue("Branch_Name"))).sendKeys("New Branch");
		try{
		if(driver.getPageSource().contains("Branch Already Exists"))
		{ 
			driver.close();
			
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
		WebElement dept=driver.findElement(By.xpath(rp.getPropertyValue("Department")));
		dept.click();
		List <WebElement> deptvalues= driver.findElements(By.xpath(rp.getPropertyValue("Department")));
		/*for(int i = 0; i <= deptvalues.size(); i++){*/
		for(WebElement i: deptvalues)
		{
			i.getText();
		    Actions actions = new Actions(driver);
		    actions.sendKeys(Keys.DOWN).build().perform();//press down arrow key
		    actions.sendKeys(Keys.ENTER).build().perform();//press enter
		}

		//here "position" is , ur desired combo box option position,
		//for ex. u want to choose 3rd option,so ur "position" will be 3.
		
		WebElement dept_category=driver.findElement(By.xpath(rp.getPropertyValue("Department_Category")));
		
		Select s=new Select(dept);
		s.selectByVisibleText("BIO-CHEMISTRY (LAB)");
		
		Select s1=new Select(dept_category);
		s1.selectByVisibleText("Diagnostic");
		driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo1"))).click();
		driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo2"))).click();
		driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo3"))).click();
		/*wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(rp.getPropertyValue("Branch_Name")), "Time left: 7 seconds"));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(rp.getPropertyValue("Building_Name")), "Time left: 7 seconds"));*/
		
		
		
	  
	  }
	

}
