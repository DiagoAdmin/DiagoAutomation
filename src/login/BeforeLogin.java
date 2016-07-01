package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import operations.TakeOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Reading_Properties;
import branch.create_branch;
import wait.ImplicitWait;
import databaseConnections.SqlConnection;

public class BeforeLogin {

		WebDriver driver;
		@BeforeSuite
		public void dbTest() throws Exception
		{
			SqlConnection.dbConnect();
			}
		@BeforeTest
		public void login() throws Exception
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
			
		}
		@BeforeClass
		public void setUp()
		{
			try
			{
				Boolean flag = true;
				if (flag)
				{
					Connection conn = SqlConnection.dbConnect();
					Statement statement = conn.createStatement();
					Reading_Properties rp=new Reading_Properties();
					rp.LoadProperties();
					String queryString = rp.getPropertyValue("loginusers");
					
					ResultSet rs = statement.executeQuery(queryString);
					
					ImplicitWait.wait(driver);
					driver.get(rp.getPropertyValue("diagodomainurl"));
					driver.manage().window().maximize();
					
					/*driver.findElement(By.xpath(rp.getPropertyValue("homelogin"))).click();*/
					ResultSetMetaData metadata = rs.getMetaData();
					int columnCount = metadata.getColumnCount();
					for (int i=0; i<=columnCount; i++)
					{
						while(rs.next())
						{
							String columnval1=rs.getString(2);
							String columnval2=rs.getString(3);
							driver.findElement(By.name(rp.getPropertyValue("username"))).sendKeys(columnval1);
							driver.findElement(By.name(rp.getPropertyValue("password"))).sendKeys(columnval2);
							driver.findElement(By.xpath(rp.getPropertyValue("Home_Login"))).click();
							
							ImplicitWait.wait(driver);

							}
						}
					}
				}
			catch (Exception e)
			{
				e.printStackTrace();
				}
		}
		@Test
		public void branchCreation() throws Exception
		{
			create_branch cb= new create_branch();
			cb.Create_Branch(driver);
		}
		@Test
		public void Operations() throws Exception
		{
			TakeOrder to=new TakeOrder();
			
		}
@AfterClass
public void tearDown() throws Exception 
{

ImplicitWait.wait(driver);

	driver.close();
	driver.quit();
}


@AfterSuite
public void dbClose()
{
	SqlConnection.dbConnectionClose();
	
}
}