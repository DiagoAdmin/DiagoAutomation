package branch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;








import wait.ImplicitWait;
import config.Reading_Properties;
import databaseConnections.SqlConnection;

public class FetchAllBranchesinBranchesGrid {
	WebDriver driver;
	public List<String> allbranches(WebDriver driver) throws Exception
	{
		List<String> list = new ArrayList<String>();
		List<WebElement>branches=driver.findElements(By.xpath("//div[@id='divEnterprises']/div"));
		/*int we=branches.size();
		for(int i=0;i<we;i++)
		{*/
		for(WebElement bran:branches)
		{
			String txt=bran.getText();
			list.add(txt);
	}
		return list;
}

	/*public void FetchAllBranches(WebDriver driver) throws Exception 
	{
		AllBranchesValidation allbrnch=new AllBranchesValidation();

			Reading_Properties rp=new Reading_Properties();
			try {
				rp.LoadProperties();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			ImplicitWait.wait(driver);


			driver.findElement(By.xpath(rp.getPropertyValue("CreateBranch"))).click();
			ImplicitWait.wait(driver);
			WebElement branch_creation=driver.findElement(By.id(rp.getPropertyValue("Branch_Name")));
			branch_creation.clear();
			branch_creation.sendKeys(allbrnch.DiagoLogin());
			String branchexists=driver.findElement(By.id("enterpriseId-error")).getText();
			try{
				if(branchexists.contains("Branch Already Exists"))
				{
				allbranches(driver);
				if(allbranches(driver).equals(allbrnch.DiagoLogin()))
				{
					
				}
				
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
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
	
			driver.findElement(By.xpath(rp.getPropertyValue("AllDays_Frame"))).click();
			
	driver.findElement(By.xpath(rp.getPropertyValue("Working_Time_From"))).sendKeys("10");
			driver.findElement(By.xpath(rp.getPropertyValue("Working_Time_To"))).sendKeys("23");
			driver.findElement(By.xpath(rp.getPropertyValue("Dept"))).click();
			
			Actions actions = new Actions(driver);
			List<WebElement> deptvalues=driver.findElements(By.xpath(rp.getPropertyValue("Department")));
			int deptvalues= driver.findElements(By.xpath(rp.getPropertyValue("Department"))).size();
			System.out.println(deptvalues.size());
			for(int i = 0; i <= deptvalues.size();i++){
				for(int j=0;j<=i;j++)
				{
			
			    actions.sendKeys(Keys.DOWN).build().perform();//press down arrow key
			    actions.sendKeys(Keys.ENTER).build().perform();//press enter
			    driver.findElement(By.xpath(rp.getPropertyValue("Dept"))).click();
			    ImplicitWait.wait(driver);

			    here "position" is , ur desired combo box option position,
				for ex. u want to choose 3rd option,so ur "position" will be 3.
			}
			}
			
			
			driver.findElement(By.xpath(rp.getPropertyValue("Dept_Category"))).click();
			ImplicitWait.wait(driver);
			List<WebElement> dept_category=driver.findElements(By.xpath(rp.getPropertyValue("Department_Category")));
			int dept_category=driver.findElements(By.xpath(rp.getPropertyValue("Department_Category"))).size();
			
			for(int i = 0; i <= dept_category.size();i++){
				for(int j=0;j<=i;j++)
				{
				
			    actions.sendKeys(Keys.DOWN).build().perform();//press down arrow key
			    actions.sendKeys(Keys.ENTER).build().perform();//press enter
			    driver.findElement(By.xpath(rp.getPropertyValue("Dept_Category"))).click();
			    ImplicitWait.wait(driver);

			    here "position" is , ur desired combo box option position,
				for ex. u want to choose 3rd option,so ur "position" will be 3.
			}
			}
			
			ImplicitWait.wait(driver);
			driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo1"))).click();
			ImplicitWait.wait(driver);
			driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo2"))).click();
			ImplicitWait.wait(driver);
			driver.findElement(By.xpath(rp.getPropertyValue("AdditionalInfo3"))).click();
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(rp.getPropertyValue("Branch_Name")), "Time left: 7 seconds"));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(rp.getPropertyValue("Building_Name")), "Time left: 7 seconds"));
			
			ImplicitWait.wait(driver);
			
		  
		  }
	
*/	
	
	
public List<String> allBranchesfromDB()
{
	List<String> str=new ArrayList<String>();
	try
	{
		Boolean flag = true;
		if (flag)
		{
			Connection conn = SqlConnection.dbConnect();
			Statement statement = conn.createStatement();
			Reading_Properties rp=new Reading_Properties();
			rp.LoadProperties();
			String queryString = rp.getPropertyValue("allbranches");
			
			ResultSet rs = statement.executeQuery(queryString);
			
	

			ResultSetMetaData metadata = rs.getMetaData();
			int columnCount = metadata.getColumnCount();
			
			for (int i=0; i<=columnCount; i++)
			{
				while(rs.next())
				{
					
					String columnval1=rs.getString(2);
					
					str.add(columnval1);
					}
				}
			}
		}
	catch (Exception e)
	{
		e.printStackTrace();
		}
	return str;
	
	
}
	
}
	
	
	