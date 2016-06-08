package config;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Reading_Properties  {
	Properties prop=new Properties();
	public void LoadProperties(WebDriver driver) throws IOException
	{
		String path =System.getProperty("user.dir");							//returns the current project directory path
		
		FileInputStream fp=new FileInputStream(path+"\\src\\config\\Locators.properties");
		FileInputStream fp1=new FileInputStream(path+"\\src\\config\\db.properties");
	
	try {
		
	prop.load(fp);
	prop.load(fp1);
	
} 
		catch (FileNotFoundException e)
		{
		e.printStackTrace();
		fp.close();
		fp1.close();
		}
	
}
	public Set<Object> getAllKeys(){
        Set<Object> keys = prop.keySet();
        return keys;
        }
	public String getPropertyValue(String key){
        return this.prop.getProperty(key);
    }
    }