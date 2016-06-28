package screenshot;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot {
	public void Screenshot(WebDriver driver) 
	{
		try {

			//Time Stamp using java
			DateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss");
			Date d=new Date();
			String time=df.format(d);

			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("D:\\krishna back up\\DiagoIssue screenshots\\"+time+".png"));

			} catch (Exception e) 
			{
			         System.out.println(e.getMessage());
			}
	}

}
