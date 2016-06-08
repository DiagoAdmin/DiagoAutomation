package login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import wait.ImplicitWait;
import databaseConnections.SqlConnection;

public class BeforeLogin {

		WebDriver driver;
		@BeforeSuite
		public void dbTest() throws IOException
		{
			SqlConnection.dbConnect(driver);
			}
		@BeforeMethod
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
			}
		@Test
		public void login() throws Exception
		{
			Login lu=new Login();
			lu.DiagoLogin(driver);
			
	}
@AfterMethod
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