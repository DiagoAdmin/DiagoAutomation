package branch;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Reading_Properties;


public class AllBranchesValidation
{
	WebDriver driver;
	Reading_Properties rp=new Reading_Properties();
	public void EmailValidation(WebDriver driver) throws Exception
	{
		try 
		{
			rp.LoadProperties();
		}
	catch (IOException e) 
		{

			e.printStackTrace();

		}
		
	}
	public List<String> Landlinevalidationmessage(WebDriver driver) throws Exception
	{
		List<String> list = new ArrayList<String>();
		List<WebElement>landlinevalidation=driver.findElements(By.id(rp.getPropertyValue("Branch_Create_Landline1_Validation")));

		for(WebElement land:landlinevalidation)
		{
			String txt=land.getText();
			list.add(txt);
	}
		return list;
	}
	
	}