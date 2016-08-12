package config;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LocatorsIdentifiers 
{
	WebDriver driver;
	Actions action;
	//Start firefox Browser
	public void startBrowserFirefox()
	{
		driver= new FirefoxDriver();		
	}
/*	//Start Chrome Browser
	public void startBrowserChrome() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver= new ChromeDriver();
	}*/
	//Maximize Browser
	public void maximiseBrowser()
	{
		driver.manage().window().maximize();
	}
	//locator type
	public int locatorType(String identifier)
	{
		int id=1;
		if (identifier=="id")
		{
			id=1;
		}
		else if (identifier=="className") 
		{
			id=2;
		}
		else if (identifier=="tagName") 
		{
			id=3;
		}
		else if (identifier=="name") 
		{
			id=4;
		}
		else if (identifier=="linkText")
		{
			id=5;
		}
		else if (identifier=="partialLinkText")
		{
			id=6;
		}
		else if (identifier=="cssSelector") 
		{
			id=7;
		}
		else if (identifier=="xpath") 
		{
			id=8;
		}
		else 
		{
			id=0;
			System.out.println("Locator type invalid");
		}		
		return id;
	}
	//WebElement 
	public WebElement webElementId(String identifier,String locator,WebDriver driver) throws Exception
	{
		int id=locatorType(identifier);
		WebElement e=null;
		switch (id)
		{
		case 1 : 
			e=driver.findElement(By.id(locator));
		              	break;
		case 2 : 
			e=driver.findElement(By.className(locator));
					  	break;
		case 3 : 
			e=driver.findElement(By.tagName(locator));
						break;
		case 4 : 
			e=driver.findElement(By.name(locator));
						break;		 
		case 5 : 
			e=driver.findElement(By.linkText(locator));
						break;		 
		case 6 : 
			e=driver.findElement(By.partialLinkText(locator));
						break;          
		case 7 : 
			e=driver.findElement(By.cssSelector(locator));
						break;
		case 8 :
			e=driver.findElement(By.xpath(locator));
						break;
		default : 
			System.out.println("Locator not found");
       	 			e=null;
		}
		return e;
	}
	//Sendkey general method
	public void sendKeys(String identifier,String locator,String content,WebDriver driver) throws Exception
	{
		
		WebElement e=webElementId(identifier, locator, driver);
		e.sendKeys(content);		
	}
	//Clear text  field method
	public void ClearTextField(String identifier,String locator) throws Exception
	{
		
		WebElement e=webElementId(identifier, locator, driver);
		e.clear();		
	}
	//click general method
	public void click(String identifier,String locator,WebDriver driver) throws Exception
	{
		WebElement e=webElementId(identifier, locator, driver); 
		e.click();
	}
	//verify title of the page
	public void verifyTitle(String title)
	{
		if(driver.getTitle().equals(title))
		{
			System.out.println(title+" displayed" );
		}
		else
		{
			System.out.println("Failed to display "+title );
			return;
		} 		
	} 
	//wait for some time
	public void waitForFindElement(long waittime) 
	{
		try 
		{
			driver.wait(waittime);			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	//Wait until the Element is present
	public void waitUntilElementPresent(String elementpath)
	{
		WebElement elementpresent=(new WebDriverWait(driver,10)).
		until(ExpectedConditions.presenceOfElementLocated
				(By.xpath(elementpath)));
	}
	
	//Verify Text
	public void verifyText(String identifier,String locator,String text) throws Exception
	{
		WebElement e=webElementId(identifier, locator, driver);
		if (e.getText().equals(text))
		{
			System.out.println(text+" displayed");
		}
		else
		{
			System.out.println(text+"Did not displayed");
			
		}
	}
	//verify element present
	public void verifyElementPresent(String identifier,String locator) throws Exception
	{
		boolean s=false;
		WebElement e=webElementId(identifier, locator, driver);
		if (e.isDisplayed())
		{
			System.out.println("Element present");
		}
		else
		{
			System.out.println("Element is not present");
		}
	}
	
	//Thread sleep
	public void sleepThread(long sleeptime) 
	{
		try
		{
			Thread.sleep(sleeptime);
		} catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	//Wait for page to load
	public void waitForPageToLoad()
	{
		try {
			for(int i=0;i< 50;)
			{
				if (driver.getTitle().length()!=0 )
				{
					System.out.println("Page loaded");
					i=51;
					break;
				}else {
					Thread.sleep(1000);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}			
	}
	
	//select frame by id
	public void selectFrameById(String locator)
	{
		driver.switchTo().frame(locator);
	}
	//Select frame default method   
	public void selectFrameDefault(){
		driver.switchTo().defaultContent();
	}
	
	//getting data from table and verifying it with the required text  
	public void verifyElementInTable(String xpathlocator,String text)
	{
		boolean a=false;
		List<WebElement> tdlist = driver.findElements(By.xpath(xpathlocator));
		for(WebElement el: tdlist)  
		{
			if (el.getText().equals(text))
			{		
				a=true;	
				break;
			}
		}
		
		if(a==true)
		{
			System.out.println(text+" was identifed");				
		}
		else
		{
			System.out.println( text+" was not identifed");
		}
	}
	//Start action
	public void startAction()
	{
		action =new Actions(driver);
	}
	//move to element
	public Actions movetoElement(String identifier,String locator) throws Exception
	{		
		WebElement e=webElementId(identifier, locator, driver);
		return action.moveToElement(e);
	}
	
	//close 
	public void closeBrowser()
	{
		driver.close();
	}
	//Quite
	public void QuitObject()
	{
		driver.quit();
	}
}