package login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import branch.create_branch;
import config.Reading_Properties;
import databaseConnections.SqlConnection;
import wait.*;

public class Login
{
	public void DiagoLogin(WebDriver driver) throws SQLException, InterruptedException {
		
		try
		{
			Boolean flag = true;
			if (flag)
			{
				Connection conn = SqlConnection.dbConnect(driver);
				Statement statement = conn.createStatement();
				Reading_Properties rp=new Reading_Properties();
				rp.LoadProperties(driver);
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
						
						driver.findElement(By.xpath(rp.getPropertyValue("Group"))).click();
						create_branch cb= new create_branch();
						cb.Create_Branch(driver);
						
						driver.findElement(By.xpath(rp.getPropertyValue("logout"))).click();
						}
					}
				}
			}
		catch (Exception e)
		{
			e.printStackTrace();
			}
		}
	}