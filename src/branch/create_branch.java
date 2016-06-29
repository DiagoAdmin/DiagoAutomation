package branch;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import screenshot.GetScreenshot;
import wait.ImplicitWait;
import config.Reading_Properties;

public class create_branch
{
	WebDriver driver;
	FetchAllBranchesinBranchesGrid FABG=new FetchAllBranchesinBranchesGrid();
	List<String> allbranchesdb=FABG.allBranchesfromDB();
	Reading_Properties rp=new Reading_Properties();
	GetScreenshot gsc=new GetScreenshot();
		public void Create_Branch(WebDriver driver) throws Exception
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
		
	List<String> txt=FABG.allbranches(driver);
		
	ImplicitWait.wait(driver);
	driver.findElement(By.xpath(rp.getPropertyValue("CreateBranch"))).click();
	ImplicitWait.wait(driver);
	
				for(int i=0;i<allbranchesdb.size();i++)
					{
						ImplicitWait.wait(driver);
						driver.findElement(By.id(rp.getPropertyValue("Branch_Name"))).sendKeys(allbranchesdb.get(i));
						ImplicitWait.wait(driver);
						List<String> branchvalidationmessage=FABG.branchvalidationmessage(driver);
						ImplicitWait.wait(driver);
							if(branchvalidationmessage.contains("Branch Already Exists")||branchvalidationmessage.contains("Branch Name is required"))
								{
								/*ImplicitWait.wait(driver);*/
								gsc.Screenshot(driver);
									driver.findElement(By.id(rp.getPropertyValue("Branch_Name"))).sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.chord(Keys.DELETE));
									/*ImplicitWait.wait(driver);*/
									continue;
				
				
								}

							else  if(!txt.equals(allbranchesdb))
								{
									ImplicitWait.wait(driver);
									WebElement build=driver.findElement(By.id(rp.getPropertyValue("Building_Name")));
									build.click();
									ImplicitWait.wait(driver);
									build.sendKeys(allbranchesdb.get(0));
									AdditionalInfo(driver);
									continue;
				
								}
			
					}

		
			}
		public void AdditionalInfo(WebDriver driver) throws Exception
			{
				/*driver.findElement(By.id(rp.getPropertyValue("Building_Name"))).sendKeys(allbranchesdb.get(0));*/
				ImplicitWait.wait(driver);
				driver.findElement(By.xpath(rp.getPropertyValue("Branch_Adress_Next"))).click();
				ImplicitWait.wait(driver);
				driver.findElement(By.xpath(rp.getPropertyValue("AllDays_Frame"))).click();
				ImplicitWait.wait(driver);
				driver.findElement(By.xpath(rp.getPropertyValue("Working_Time_From"))).sendKeys("10");
				ImplicitWait.wait(driver);
				driver.findElement(By.xpath(rp.getPropertyValue("Working_Time_To"))).sendKeys("12");
				ImplicitWait.wait(driver);
				ImplicitWait.wait(driver);
				driver.findElement(By.xpath(rp.getPropertyValue("Dept"))).click();
				ImplicitWait.wait(driver);
				List<WebElement> deptvalues= driver.findElements(By.xpath(rp.getPropertyValue("Department")));
				ImplicitWait.wait(driver);
				Actions actions = new Actions(driver);
					for(int i = 0; i <= deptvalues.size(); i++)
						{	ImplicitWait.wait(driver);
							/*for(WebElement i: deptvalues)*/
							for(int j=deptvalues.size();j>=i;j--)
								{
									actions.sendKeys(Keys.DOWN).build().perform();
									actions.sendKeys(Keys.ENTER).build().perform();
									driver.findElement(By.xpath(rp.getPropertyValue("Dept"))).click();
									ImplicitWait.wait(driver);
								}
						}
					driver.findElement(By.xpath(rp.getPropertyValue("Dept_Category"))).click();
					ImplicitWait.wait(driver);
					List<WebElement> dept_category=driver.findElements(By.xpath(rp.getPropertyValue("Department_Category")));
					
					for(int i = 0; i <= dept_category.size();i++)
						{
							for(int j=0;j<=i;j++)
								{

									actions.sendKeys(Keys.DOWN).build().perform();//press down arrow key
									actions.sendKeys(Keys.ENTER).build().perform();//press enter
									driver.findElement(By.xpath(rp.getPropertyValue("Dept_Category"))).click();
									ImplicitWait.wait(driver);

								}
						}
					
				driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo1"))).click();
				ImplicitWait.wait(driver);
				driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo2"))).click();
				ImplicitWait.wait(driver);
				driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo3"))).click();
			}
	}