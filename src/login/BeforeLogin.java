package login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import branch.create_branch;
import wait.ImplicitWait;
import databaseConnections.SqlConnection;

public class BeforeLogin {

		WebDriver driver;
		@BeforeSuite
		public void dbTest() throws IOException
		{
			SqlConnection.dbConnect();
			}
		@BeforeClass
		public void setUp() throws InterruptedException
		{
			/*FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("browser.startup.homepage", "about:blank");
			fp.setPreference("startup.homepage_welcome_url", "about:blank");
			fp.setPreference("startup.homepage_welcome_url.additional", "about:blank");*/
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
			/*driver = new FirefoxDriver(fp);*/
			ImplicitWait.wait(driver);
			}
		public void login() throws Exception
		{
			Login lu=new Login();
			lu.DiagoLogin();
		}
		@Test
		public void branchCreation() throws Exception
		{
			create_branch cb= new create_branch();
			cb.Create_Branch();
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