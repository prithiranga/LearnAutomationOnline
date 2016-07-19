package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Helper {
	
	public static String captureScreenshot(WebDriver w, String screenshotName)
	{
		TakesScreenshot ts = (TakesScreenshot)w;
		
		File scr = ts.getScreenshotAs(OutputType.FILE);
		
		//File scrFile  =  ((TakesScreenshot)w).getScreenshotAs(OutputType.FILE);
		 
		String destination = "D:\\files\\programs\\com.learnautomation.hybrid\\Screenshots"  +screenshotName +System.currentTimeMillis()+".png";
		
		try
		{
			FileUtils.copyFile(scr,new File(destination));
		} catch (IOException e)
		{
			System.out.println("fail to capture screenshot" + e.getMessage());
		}
		
		return destination;
		
	}

}
