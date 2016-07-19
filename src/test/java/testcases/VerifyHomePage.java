package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class VerifyHomePage {
	
	WebDriver w;
	
	@BeforeMethod
	public void setUp()
	{
	w = BrowserFactory.getBrowser("firefox");
	
	w.get(DataProviderFactory.getConfig().getApplicationUrl());
	}

	@Test
	public void testHomePage()
	{
		HomePage home = PageFactory.initElements(w, HomePage.class); 	
	
		String title=home.getTitle();
	
		System.out.println(" My Title is "+title );
	
		Assert.assertTrue(title.contains("learn-automation"));
	
	}
	
   @AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(w);
	}
    
    
}