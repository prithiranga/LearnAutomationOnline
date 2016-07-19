package testcases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLogInPage {
	
	WebDriver w;
	
	@BeforeMethod
	public void setUp()
	{
	w =BrowserFactory.getBrowser("firefox");
	
	w.get(DataProviderFactory.getConfig().getApplicationUrl());
	}

	@Test
	public void testHomePage() throws Exception
	{
		HomePage home = PageFactory.initElements(w, HomePage.class); 	
	
		String title = home.getTitle();
	
		System.out.println(" My Title is "+title );
	
		//Assert.assertTrue(title.contains("learn-automation"));
		
		home.clickOnLogIn();
	
		LoginPage log = PageFactory.initElements(w, LoginPage.class); 
	
		log. LogInApp(DataProviderFactory.getExcel().getData(0,0,0),DataProviderFactory.getExcel().getData(0,0,1));
		
		log.ImageLink();
		
		log.logOutLink();
		
	 }
	
	
    @AfterMethod
	public void tearDown()
	{
    	w.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		BrowserFactory.closeBrowser(w);
	}
    
    
}