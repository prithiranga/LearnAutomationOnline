package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory {

  static WebDriver w;
	public static WebDriver getBrowser(String browser)
	{
		if (browser.equalsIgnoreCase("FireFox"))
		{
			w= new FirefoxDriver();
	
		}
		else if (browser.equalsIgnoreCase("Chrome"))
				{
			
			//ConfigDataProvider config = new ConfigDataProvider();
			System.setProperty("WebDriver.Chrome.Driver","DataProviderFactory.getconfig().getChromePath()");
			w= new ChromeDriver();
			
				}

		else if (browser.equalsIgnoreCase("IE"))
		{
			//ConfigDataProvider config = new ConfigDataProvider();
			System.setProperty("WebDriver.InternetExplorer.Driver","DataProviderFactory.getconfig().getIEPath()");
			w= new InternetExplorerDriver();
		}
	  w.manage().window().maximize();
	  w.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	return w;
	}
	
	
	public static void closeBrowser(WebDriver w)
	{
		w.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		w.quit();
		
	}
	
}
