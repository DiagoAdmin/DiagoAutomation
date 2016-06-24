package branch;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import wait.ImplicitWait;
import config.Reading_Properties;

public class create_branch {
	WebDriver driver;
	Reading_Properties rp=new Reading_Properties();
	public void Create_Branch(WebDriver driver) throws Exception
	  {
		try 
		{
			rp.LoadProperties();
		}
		catch (IOException e) 
		{
			
			e.printStackTrace();
			System.out.println();
		}
		WebElement ele=driver.findElement(By.xpath(rp.getPropertyValue("Group")));
		ele.click();
		ImplicitWait.wait(driver);
		driver.findElement(By.xpath(rp.getPropertyValue("Branches"))).click();
		ImplicitWait.wait(driver);
		FetchAllBranchesinBranchesGrid FABG=new FetchAllBranchesinBranchesGrid();
		/*FABG.FetchAllBranches(driver);*/
		List<String> txt=FABG.allbranches(driver);
		
		List<String> allbranchesdb=FABG.allBranchesfromDB();
		ImplicitWait.wait(driver);
		driver.findElement(By.xpath(rp.getPropertyValue("CreateBranch"))).click();
		String branchexists=driver.findElement(By.id("enterpriseId-error")).getText();
		
		
		for(int i=0;i<allbranchesdb.size();i++)
		{
			driver.findElement(By.id(rp.getPropertyValue("Branch_Name"))).sendKeys(allbranchesdb.get(i));
			
			if(!txt.equals(allbranchesdb))
			{
				AdditionalInfo();
				continue;
			}
			else if(branchexists != null)
			{
				
			}
		}

		try{
			if(branchexists.contains("Branch Already Exists"))
		/*if(driver.getPageSource().contains("Branch Already Exists"))*/
		{ 
			driver.close();
			System.out.println();
			driver.quit();
			
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  }
		public void AdditionalInfo() throws Exception
		{
		driver.findElement(By.id(rp.getPropertyValue("Building_Name"))).sendKeys("New Branch");
		driver.findElement(By.xpath(rp.getPropertyValue("Branch_Adress_Next"))).click();
		ImplicitWait.wait(driver);
		driver.findElement(By.xpath(rp.getPropertyValue("AllDays_Frame"))).click();
		driver.findElement(By.xpath(rp.getPropertyValue("Working_Time_From"))).sendKeys("10");
		driver.findElement(By.xpath(rp.getPropertyValue("Working_Time_To"))).sendKeys("12");
		WebElement dept=driver.findElement(By.xpath(rp.getPropertyValue("Department")));
		dept.click();
		List<WebElement> deptvalues= driver.findElements(By.xpath(rp.getPropertyValue("Department")));
		Actions actions = new Actions(driver);
		for(int i = 0; i <= deptvalues.size(); i++)
		{
		/*for(WebElement i: deptvalues)*/
			for(int j=deptvalues.size();j>=i;j--)
			{
			actions.sendKeys(Keys.DOWN).build().perform();//press down arrow key
		    actions.sendKeys(Keys.ENTER).build().perform();//press enter
		    driver.findElement(By.xpath(rp.getPropertyValue("Dept"))).click();
		}
		}
		driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo1"))).click();
		driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo2"))).click();
		driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo3"))).click();
	  }
}