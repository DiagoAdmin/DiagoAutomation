package branch;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
			System.out.println(branches.size());
			String txt=bran.getText();
			list.add(txt.split("\n")[0]);
	}
		
		return list;
}

	public List<String> branchvalidationmessage(WebDriver driver) throws Exception
	{
		List<String> list = new ArrayList<String>();
		List<WebElement>branchvalidation=driver.findElements(By.xpath("//*[@id='enterpriseId-error']"));

		for(WebElement bran:branchvalidation)
		{
			String txt=bran.getText();
			list.add(txt);
	}
		return list;
	}
	
	
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
					
					String columnval1=rs.getString(1);
					
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
	
	
	